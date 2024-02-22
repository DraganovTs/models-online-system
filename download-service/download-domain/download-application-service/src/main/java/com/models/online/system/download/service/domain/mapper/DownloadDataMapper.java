package com.models.online.system.download.service.domain.mapper;

import com.models.online.system.domain.valueobject.CategoryId;
import com.models.online.system.domain.valueobject.CustomerId;
import com.models.online.system.domain.valueobject.ModelId;
import com.models.online.system.domain.valueobject.Money;
import com.models.online.system.download.service.domain.dto.create.CreateDownloadCommand;
import com.models.online.system.download.service.domain.dto.create.CreateDownloadResponse;
import com.models.online.system.download.service.domain.dto.create.DownloadModel;
import com.models.online.system.download.service.domain.dto.create.UserAddressInfo;
import com.models.online.system.download.service.domain.dto.track.TrackDownloadResponse;
import com.models.online.system.download.service.domain.entity.Category;
import com.models.online.system.download.service.domain.entity.Download;
import com.models.online.system.download.service.domain.entity.DownloadItem;
import com.models.online.system.download.service.domain.entity.Model;
import com.models.online.system.download.service.domain.valueobject.UserInformation;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class DownloadDataMapper {


    public Category createDownloadCommandToRestaurant(CreateDownloadCommand createDownloadCommand) {
        return Category.Builder.builder()
                .categoryId(new CategoryId(createDownloadCommand.getCategoryId()))
                .models(createDownloadCommand.getItems().stream().map(downloadModel ->
                                new Model(new ModelId(downloadModel.getModelId())))
                        .collect(Collectors.toList()))
                .build();
    }


    public Download createDownloadCommandToDownload(CreateDownloadCommand createDownloadCommand) {
        return Download.Builder.builder()
                .customerId(new CustomerId(createDownloadCommand.getCustomerId()))
                .categoryId(new CategoryId(createDownloadCommand.getCategoryId()))
                .userInfo(UserInformationToDownloadInformation(createDownloadCommand.getDownloadAddress()))
                .price(new Money(createDownloadCommand.getPrice()))
                .items(downloadItemsToDownloadItemsEntities(createDownloadCommand.getItems()))
                .build();
    }

    public CreateDownloadResponse createDownloadResponse(Download download) {
        return CreateDownloadResponse.builder()
                .downloadTrackingId(download.getTrackingId().getValue())
                .downloadStatus(download.getDownloadStatus())
                .build();
    }

    public TrackDownloadResponse downloadToTrackDownloadResponse(Download download) {
        return TrackDownloadResponse.builder()
                .downloadTrackingId(download.getTrackingId().getValue())
                .downloadStatus(download.getDownloadStatus())
                .failureMessages(download.getFailureMessages())
                .build();
    }

    private List<DownloadItem> downloadItemsToDownloadItemsEntities(List<DownloadModel> downloadItems) {
        return downloadItems.stream()
                .map(downloadModel ->
                        DownloadItem.Builder.builder()
                                .model(new Model(new ModelId(downloadModel.getModelId())))
                                .price(new Money(downloadModel.getPrice()))
                                .build())
                .collect(Collectors.toList());
    }

    private UserInformation UserInformationToDownloadInformation(UserAddressInfo downloadAddress) {
        return new UserInformation(
                UUID.randomUUID(),
                downloadAddress.getEmail(),
                downloadAddress.getCountry(),
                downloadAddress.getCity()
        );
    }
}
