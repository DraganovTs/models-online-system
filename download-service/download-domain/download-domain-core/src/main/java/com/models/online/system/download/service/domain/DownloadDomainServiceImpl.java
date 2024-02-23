package com.models.online.system.download.service.domain;

import com.models.online.system.download.service.domain.entity.Category;
import com.models.online.system.download.service.domain.entity.Download;
import com.models.online.system.download.service.domain.entity.Model;
import com.models.online.system.download.service.domain.event.DownloadCancelEvent;
import com.models.online.system.download.service.domain.event.DownloadCreatedEvent;
import com.models.online.system.download.service.domain.event.DownloadPaidEvent;
import com.models.online.system.download.service.domain.exception.DownloadDomainException;
import lombok.extern.slf4j.Slf4j;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@Slf4j
public class DownloadDomainServiceImpl implements DownloadDomainService {

    public static final String UTC = "UTC";

    @Override
    public DownloadCreatedEvent validateAndInitiateDownload(Download download, Category category) {
        validateCategory(category);
        setDownloadModelInformation(download, category);
        download.validateDownload();
        download.initializeDownload();
        log.info("Download whit id: {} is initiated", download.getId().getValue());
        return new DownloadCreatedEvent(download, ZonedDateTime.now(ZoneId.of(UTC)));
    }


    @Override
    public DownloadPaidEvent payDownload(Download download) {
        download.pay();
        log.info("Download whit id: {} is paid", download.getId().getValue());
        return new DownloadPaidEvent(download, ZonedDateTime.now(ZoneId.of(UTC)));
    }

    @Override
    public void approveDownload(Download download) {
        download.approve();
        log.info("Download whit id: {} is approved", download.getId().getValue());
    }

    @Override
    public DownloadCancelEvent cancelDownloadPayment(Download download, List<String> failureMessages) {
        download.initCancel(failureMessages);
        log.info("Download payment is cancelling for download whit id: {} ", download.getId().getValue());
        return new DownloadCancelEvent(download, ZonedDateTime.now(ZoneId.of(UTC)));
    }

    @Override
    public void cancelDownload(Download download, List<String> failureMessages) {
        download.cancel(failureMessages);
        log.info("Download whit id: {} is cancelled", download.getId().getValue());
    }

    private void validateCategory(Category category) {
        if (!category.isActive()) {
            throw new DownloadDomainException("Category with id " + category.getId().getValue() +
                    "is currently not active!");
        }
    }

    private void setDownloadModelInformation(Download download, Category category) {
        download.getItems().forEach(downloadItem -> category.getModels().forEach(categoryModel -> {
            Model currentModel = downloadItem.getModel();
            if (currentModel.equals(categoryModel)) {
                currentModel.updateWhitConfirmedNameAndPrice(categoryModel.getName(), categoryModel.getPrice());
            }
        }));
    }
}
