package com.models.online.system.download.service.dataaccess.download.mapper;

import com.models.online.system.domain.valueobject.*;
import com.models.online.system.download.service.dataaccess.download.entity.DownloadEntity;
import com.models.online.system.download.service.dataaccess.download.entity.DownloadModelEntity;
import com.models.online.system.download.service.dataaccess.download.entity.UserInformationEntity;
import com.models.online.system.download.service.domain.entity.Download;
import com.models.online.system.download.service.domain.entity.DownloadItem;
import com.models.online.system.download.service.domain.entity.Model;
import com.models.online.system.download.service.domain.valueobject.DownloadItemId;
import com.models.online.system.download.service.domain.valueobject.TrackingId;
import com.models.online.system.download.service.domain.valueobject.UserInformation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.models.online.system.download.service.domain.entity.Download.FAILURE_MESSAGE_DELIMITER;

@Component
public class DownloadDataAccessMapper {

    public DownloadEntity downloadToDownloadEntity(Download download) {
        DownloadEntity downloadEntity = DownloadEntity.builder()
                .id(download.getId().getValue())
                .customerId(download.getCustomerId().getValue())
                .categoryId(download.getCategoryId().getValue())
                .trackingId(download.getTrackingId().getValue())
                .userInfo(userInfoToUserInfoEntity(download.getUserInfo()))
                .price(download.getPrice().getAmount())
                .models(downloadModelToDownloadModelsEntity(download.getItems()))
                .downloadStatus(download.getDownloadStatus())
                .failureMessages(download.getFailureMessages() != null ?
                        String.join(FAILURE_MESSAGE_DELIMITER, download.getFailureMessages()) : "")
                .build();
        downloadEntity.getUserInfo().setDownload(downloadEntity);
        downloadEntity.getModels().forEach(downloadModelEntity -> downloadModelEntity.setDownload(downloadEntity));

        return downloadEntity;
    }

    public Download downloadEntityToDownload(DownloadEntity downloadEntity) {
        return Download.Builder.builder()
                .downloadId(new DownloadId(downloadEntity.getId()))
                .customerId(new CustomerId(downloadEntity.getCustomerId()))
                .categoryId(new CategoryId(downloadEntity.getCategoryId()))
                .userInfo(userInformationEntityToUserInformation(downloadEntity.getUserInfo()))
                .price(new Money(downloadEntity.getPrice()))
                .items(downloadModelsEntityToDownloadItems(downloadEntity.getModels()))
                .trackingId(new TrackingId(downloadEntity.getTrackingId()))
                .downloadStatus(downloadEntity.getDownloadStatus())
                .failureMessages(downloadEntity.getFailureMessages().isEmpty() ? new ArrayList<>() :
                        new ArrayList<>(Arrays.asList(downloadEntity.getFailureMessages()
                                .split(FAILURE_MESSAGE_DELIMITER))))
                .build();
    }

    private List<DownloadItem> downloadModelsEntityToDownloadItems(List<DownloadModelEntity> models) {
        return models.stream()
                .map(downloadModelEntity -> DownloadItem.Builder.builder()
                        .id(new DownloadItemId(downloadModelEntity.getId()))
                        .model(new Model(new ModelId(downloadModelEntity.getModelId())))
                        .price(new Money(downloadModelEntity.getPrice()))
                        .build())
                .collect(Collectors.toList());
    }

    private UserInformation userInformationEntityToUserInformation(UserInformationEntity userInfo) {
        return new UserInformation(userInfo.getId(),
                userInfo.getEmail(), userInfo.getCountry(), userInfo.getCity());
    }

    private List<DownloadModelEntity> downloadModelToDownloadModelsEntity(List<DownloadItem> items) {
        return items.stream()
                .map(downloadItem -> DownloadModelEntity.builder()
                        .id(downloadItem.getId().getValue())
                        .modelId(downloadItem.getModel().getId().getValue())
                        .price(downloadItem.getPrice().getAmount())
                        .build())
                .collect(Collectors.toList());
    }

    private UserInformationEntity userInfoToUserInfoEntity(UserInformation userInfo) {
        return UserInformationEntity.builder()
                .id(userInfo.getId())
                .country(userInfo.getCountry())
                .city(userInfo.getCity())
                .email(userInfo.getEmail())
                .build();
    }
}
