package com.models.online.system.download.service.domain.entity;

import com.models.online.system.domain.entity.BaseEntity;
import com.models.online.system.domain.valueobject.DownloadId;
import com.models.online.system.domain.valueobject.Money;
import com.models.online.system.download.service.domain.valueobject.DownloadItemId;

public class DownloadItem extends BaseEntity<DownloadItemId> {
    private DownloadId downloadId;
    private final Model model;
    private final Money price;

    private DownloadItem(Builder builder) {
        super.setId(builder.downloadItemId);
        model = builder.model;
        price = builder.price;
    }

    boolean isPriceValid(){
        return price.isGreaterThanZero() &&
                price.equals(model.getPrice()) ;
    }

    public void initializeDownloadItem(DownloadId downloadId, DownloadItemId downloadItemId) {
        this.downloadId = downloadId;
        super.setId(downloadItemId);
    }

    public DownloadId getDownloadId() {
        return downloadId;
    }

    public Model getModel() {
        return model;
    }

    public Money getPrice() {
        return price;
    }


    public static final class Builder {
        private DownloadItemId downloadItemId;
        private Model model;
        private Money price;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(DownloadItemId val) {
            downloadItemId = val;
            return this;
        }

        public Builder model(Model val) {
            model = val;
            return this;
        }

        public Builder price(Money val) {
            price = val;
            return this;
        }

        public DownloadItem build() {
            return new DownloadItem(this);
        }
    }
}
