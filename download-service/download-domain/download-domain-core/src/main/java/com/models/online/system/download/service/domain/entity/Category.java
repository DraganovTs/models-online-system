package com.models.online.system.download.service.domain.entity;

import com.models.online.system.domain.entity.AggregateRoot;
import com.models.online.system.domain.valueobject.CategoryId;

import java.util.List;

public class Category extends AggregateRoot<CategoryId> {
    private final List<Model> models;
    private boolean active;

    private Category(Builder builder) {
        super.setId(builder.categoryId);
        models = builder.models;
        active = builder.active;
    }


    public List<Model> getModels() {
        return models;
    }

    public boolean isActive() {
        return active;
    }

    public static final class Builder {
        private CategoryId categoryId;
        private List<Model> models;
        private boolean active;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder categoryId(CategoryId val) {
            categoryId = val;
            return this;
        }

        public Builder models(List<Model> val) {
            models = val;
            return this;
        }

        public Builder active(boolean val) {
            active = val;
            return this;
        }

        public Category build() {
            return new Category(this);
        }
    }
}
