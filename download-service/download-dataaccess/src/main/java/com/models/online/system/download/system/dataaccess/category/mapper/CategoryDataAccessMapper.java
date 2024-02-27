package com.models.online.system.download.system.dataaccess.category.mapper;

import com.models.online.system.domain.valueobject.CategoryId;
import com.models.online.system.domain.valueobject.ModelId;
import com.models.online.system.domain.valueobject.Money;
import com.models.online.system.download.service.domain.entity.Category;
import com.models.online.system.download.service.domain.entity.Model;
import com.models.online.system.download.system.dataaccess.category.entity.CategoryEntity;
import com.models.online.system.download.system.dataaccess.category.exception.CategoryDataAccessException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class CategoryDataAccessMapper {

    public List<UUID> categoryToCategoryModels(Category category){
        return category.getModels().stream()
                .map(model -> model.getId().getValue())
                .collect(Collectors.toList());
    }

    public Category categoryEntityToCategory(List<CategoryEntity> categoryEntities){
        CategoryEntity category =
                categoryEntities.stream().findFirst().orElseThrow(() ->
                        new CategoryDataAccessException("Category could not be found!"));

        List<Model> categoryModels = categoryEntities.stream().map(categoryEntity ->
                new Model(new ModelId(categoryEntity.getModelId()), categoryEntity.getModelName(),
                        new Money(categoryEntity.getProductPrice()))).toList();

        return Category.Builder.builder()
                .categoryId(new CategoryId(category.getCategoryId()))
                .active(category.getCategoryActive())
                .build();
    }
}
