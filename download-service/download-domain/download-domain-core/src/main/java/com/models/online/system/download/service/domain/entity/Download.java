package com.models.online.system.download.service.domain.entity;

import com.models.online.system.domain.entity.AggregateRoot;
import com.models.online.system.domain.valueobject.*;
import com.models.online.system.download.service.domain.exception.DownloadDomainException;
import com.models.online.system.download.service.domain.valueobject.DownloadItemId;
import com.models.online.system.download.service.domain.valueobject.TrackingId;
import com.models.online.system.download.service.domain.valueobject.UserInformation;

import java.util.List;
import java.util.UUID;

public class Download extends AggregateRoot<DownloadId> {
    private final CustomerId customerId;
    private final CategoryId categoryId;
    private final UserInformation userInfo;
    private final Money price;
    private final List<DownloadItem> items;

    private TrackingId trackingId;
    private DownloadStatus downloadStatus;
    private List<String> failureMessages;

    private Download(Builder builder) {
        super.setId(builder.downloadId);
        customerId = builder.customerId;
        categoryId = builder.categoryId;
        userInfo = builder.userInfo;
        price = builder.price;
        items = builder.items;
        trackingId = builder.trackingId;
        downloadStatus = builder.downloadStatus;
        failureMessages = builder.failureMessages;
    }

    public void initializeDownload() {
        setId(new DownloadId(UUID.randomUUID()));
        trackingId = new TrackingId(UUID.randomUUID());
        downloadStatus = DownloadStatus.PENDING;
        initializeDownloadItems();
    }

    public void validateDownload() {
        validateInitialDownload();
        validateTotalPrice();
        validateItemsPrice();
    }


    private void validateInitialDownload() {
        if (downloadStatus != null || getId() != null) {
            throw new DownloadDomainException("Download is not in correct state for initialization!");
        }
    }

    private void validateTotalPrice() {
        if (price == null || !price.isGreaterThanZero()) {
            throw new DownloadDomainException("Total price must be greater than zero!");
        }
    }

    private void validateItemsPrice() {
        Money downloadItemsTotal = items.stream().map(downloadItem -> {
            validateItemPrice(downloadItem);
            return downloadItem.getPrice();
        }).reduce(Money.ZERO, Money::add);

        if (!price.equals(downloadItemsTotal)) {
            throw new DownloadDomainException("Total price " + price.getAmount()
                    + " is not equal to to Download items total: " + downloadItemsTotal.getAmount() + "!");
        }
    }

    private void validateItemPrice(DownloadItem downloadItem) {
        if (!downloadItem.isPriceValid()) {
            throw new DownloadDomainException("Download item price: " + downloadItem.getPrice().getAmount()
                    + " is not valid for model " + downloadItem.getModel().getId().getValue());
        }
    }

    void initializeDownloadItems() {
        long itemId = 1;
        for (DownloadItem downloadItem : items) {
            downloadItem.initializeDownloadItem(super.getId(), new DownloadItemId(itemId++));
        }
    }


    public CustomerId getCustomerId() {
        return customerId;
    }

    public CategoryId getCategoryId() {
        return categoryId;
    }

    public UserInformation getUserInfo() {
        return userInfo;
    }

    public Money getPrice() {
        return price;
    }

    public List<DownloadItem> getItems() {
        return items;
    }

    public TrackingId getTrackingId() {
        return trackingId;
    }

    public DownloadStatus getDownloadStatus() {
        return downloadStatus;
    }

    public List<String> getFailureMessages() {
        return failureMessages;
    }

    public static final class Builder {
        private DownloadId downloadId;
        private CustomerId customerId;
        private CategoryId categoryId;
        private UserInformation userInfo;
        private Money price;
        private List<DownloadItem> items;
        private TrackingId trackingId;
        private DownloadStatus downloadStatus;
        private List<String> failureMessages;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder downloadId(DownloadId val) {
            downloadId = val;
            return this;
        }

        public Builder customerId(CustomerId val) {
            customerId = val;
            return this;
        }

        public Builder categoryId(CategoryId val) {
            categoryId = val;
            return this;
        }

        public Builder userInfo(UserInformation val) {
            userInfo = val;
            return this;
        }

        public Builder price(Money val) {
            price = val;
            return this;
        }

        public Builder items(List<DownloadItem> val) {
            items = val;
            return this;
        }

        public Builder trackingId(TrackingId val) {
            trackingId = val;
            return this;
        }

        public Builder downloadStatus(DownloadStatus val) {
            downloadStatus = val;
            return this;
        }

        public Builder failureMessages(List<String> val) {
            failureMessages = val;
            return this;
        }

        public Download build() {
            return new Download(this);
        }
    }
}
