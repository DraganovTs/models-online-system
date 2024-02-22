package com.models.online.system.download.service.domain;

import com.models.online.system.download.service.domain.dto.create.CreateDownloadCommand;
import com.models.online.system.download.service.domain.entity.Category;
import com.models.online.system.download.service.domain.entity.Customer;
import com.models.online.system.download.service.domain.entity.Download;
import com.models.online.system.download.service.domain.event.DownloadCreatedEvent;
import com.models.online.system.download.service.domain.exception.DownloadDomainException;
import com.models.online.system.download.service.domain.mapper.DownloadDataMapper;
import com.models.online.system.download.service.domain.ports.output.repository.CategoryRepository;
import com.models.online.system.download.service.domain.ports.output.repository.CustomerRepository;
import com.models.online.system.download.service.domain.ports.output.repository.DownloadRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class DownloadCreateHelper {

    private final DownloadDomainService downloadDomainService;
    private final DownloadRepository downloadRepository;
    private final CustomerRepository customerRepository;
    private final CategoryRepository categoryRepository;
    private final DownloadDataMapper downloadDataMapper;

    public DownloadCreateHelper(DownloadDomainService downloadDomainService,
                                DownloadRepository downloadRepository,
                                CustomerRepository customerRepository,
                                CategoryRepository categoryRepository,
                                DownloadDataMapper downloadDataMapper) {
        this.downloadDomainService = downloadDomainService;
        this.downloadRepository = downloadRepository;
        this.customerRepository = customerRepository;
        this.categoryRepository = categoryRepository;
        this.downloadDataMapper = downloadDataMapper;
    }

    @Transactional
    public DownloadCreatedEvent persistDownload(CreateDownloadCommand createDownloadCommand){
        checkCustomer(createDownloadCommand.getCustomerId());
        Category category = checkCategory(createDownloadCommand);
        Download download = downloadDataMapper.createDownloadCommandToDownload(createDownloadCommand);
        DownloadCreatedEvent downloadCreatedEvent =
                downloadDomainService.validateAndInitiateDownload(download, category);
        saveDownload(download);
        log.info("Download is saved whit id: {}",downloadCreatedEvent.getDownload().getId());
        return downloadCreatedEvent;
    }

    private Category checkCategory(CreateDownloadCommand createDownloadCommand) {
        Category category = downloadDataMapper.createDownloadCommandToCategory(createDownloadCommand);
        Optional<Category> optionalInformation = categoryRepository.findCategoryInformation(category);
        if (optionalInformation.isEmpty()) {
            log.warn("Could not find category whit category id: {}", createDownloadCommand.getCategoryId());
            throw new DownloadDomainException("Could not find category whit category id: " +
                    createDownloadCommand.getCategoryId());
        }
        return optionalInformation.get();
    }
    private void checkCustomer(UUID customerId) {
        Optional<Customer> customer = customerRepository.findCustomer(customerId);
        if (customer.isEmpty()) {
            log.warn("Could not find customer whit customer id: {}", customerId);
            throw new DownloadDomainException("Could not find customer whit customer id: " + customerId);
        }
    }

    private Download saveDownload(Download download) {
        Download downloadResult = downloadRepository.save(download);
        if (downloadResult == null) {
            log.error("Could not save download!");
            throw new DownloadDomainException("Could not save download!");
        }
        log.info("Download is saved whit id: {}", downloadResult.getId());
        return downloadResult;
    }
}
