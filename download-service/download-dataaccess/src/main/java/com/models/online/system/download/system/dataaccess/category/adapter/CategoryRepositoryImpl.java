package com.models.online.system.download.system.dataaccess.category.adapter;

import com.models.online.system.download.service.domain.entity.Category;
import com.models.online.system.download.service.domain.ports.output.repository.CategoryRepository;
import com.models.online.system.download.system.dataaccess.category.entity.CategoryEntity;
import com.models.online.system.download.system.dataaccess.category.mapper.CategoryDataAccessMapper;
import com.models.online.system.download.system.dataaccess.category.repository.CategoryJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class CategoryRepositoryImpl implements CategoryRepository {

    private final CategoryJpaRepository categoryJpaRepository;
    private final CategoryDataAccessMapper categoryDataAccessMapper;

    public CategoryRepositoryImpl(CategoryJpaRepository categoryJpaRepository, CategoryDataAccessMapper categoryDataAccessMapper) {
        this.categoryJpaRepository = categoryJpaRepository;
        this.categoryDataAccessMapper = categoryDataAccessMapper;
    }

    @Override
    public Optional<Category> findCategoryInformation(Category category) {
        List<UUID> categoryModels =
                categoryDataAccessMapper.categoryToCategoryModels(category);
        Optional<List<CategoryEntity>> categoryEntities = categoryJpaRepository
                .findByCategoryIdAndModelIdIn(category.getId().getValue(),
                        categoryModels);
        return categoryEntities.map(categoryDataAccessMapper::categoryEntityToCategory);
    }
}
