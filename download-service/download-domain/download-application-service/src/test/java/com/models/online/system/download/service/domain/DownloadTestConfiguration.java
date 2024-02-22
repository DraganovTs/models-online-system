package com.models.online.system.download.service.domain;

import com.models.online.system.download.service.domain.ports.output.messaeg.publisher.categoryapproval.DownloadPaidCategoryRequestMessagePublisher;
import com.models.online.system.download.service.domain.ports.output.messaeg.publisher.payment.DownloadCancelPaymentRequestMessagePublisher;
import com.models.online.system.download.service.domain.ports.output.messaeg.publisher.payment.DownloadCreatedPaymentRequestMessagePublisher;
import com.models.online.system.download.service.domain.ports.output.repository.CategoryRepository;
import com.models.online.system.download.service.domain.ports.output.repository.CustomerRepository;
import com.models.online.system.download.service.domain.ports.output.repository.DownloadRepository;
import org.mockito.Mockito;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "com.models.online.system")
public class DownloadTestConfiguration {

    @Bean
    public DownloadCreatedPaymentRequestMessagePublisher downloadCreatedPaymentRequestMessagePublisher() {
        return Mockito.mock(DownloadCreatedPaymentRequestMessagePublisher.class);
    }

    @Bean
    public DownloadCancelPaymentRequestMessagePublisher downloadCancelPaymentRequestMessagePublisher() {
        return Mockito.mock(DownloadCancelPaymentRequestMessagePublisher.class);
    }

    @Bean
    public DownloadPaidCategoryRequestMessagePublisher downloadPaidCategoryRequestMessagePublisher() {
        return Mockito.mock(DownloadPaidCategoryRequestMessagePublisher.class);
    }

    @Bean
    public DownloadRepository downloadRepository() {
        return Mockito.mock(DownloadRepository.class);
    }

    @Bean
    public CustomerRepository customerRepository() {
        return Mockito.mock(CustomerRepository.class);
    }

    @Bean
    public CategoryRepository categoryRepository() {
        return Mockito.mock(CategoryRepository.class);
    }

    @Bean
    public DownloadDomainService downloadDomainService() {
        return new DownloadDomainServiceImpl();
    }
}
