package com.models.online.system.download.system.dataaccess.category.entity;

import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryEntityId implements Serializable {


    private UUID categoryId;

    private UUID modelId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryEntityId that = (CategoryEntityId) o;
        return categoryId.equals(that.categoryId) && modelId.equals(that.modelId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, modelId);
    }
}
