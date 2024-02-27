package com.models.online.system.download.system.dataaccess.category.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@IdClass(CategoryEntityId.class)
@Table(name = "download_category_m_view", schema = "category")
@Entity
public class CategoryEntity {

    @Id
    private UUID categoryId;
    @Id
    private UUID modelId;

    private String categoryName;
    private Boolean categoryActive;
    private String modelName;
    private BigDecimal productPrice;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryEntity that = (CategoryEntity) o;
        return categoryId.equals(that.categoryId) && modelId.equals(that.modelId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, modelId);
    }
}
