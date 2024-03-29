package com.models.online.system.download.service.domain.entity;

import com.models.online.system.domain.entity.BaseEntity;
import com.models.online.system.domain.valueobject.ModelId;
import com.models.online.system.domain.valueobject.Money;

public class Model extends BaseEntity<ModelId> {
    private String name;
    private Money price;

    public Model(ModelId modelId, String name, Money price) {
        super.setId(modelId);
        this.name = name;
        this.price = price;
    }

    public Model(ModelId modelId) {
        super.setId(modelId);
    }

    public void updateWhitConfirmedNameAndPrice(String name, Money price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Money getPrice() {
        return price;
    }
}
