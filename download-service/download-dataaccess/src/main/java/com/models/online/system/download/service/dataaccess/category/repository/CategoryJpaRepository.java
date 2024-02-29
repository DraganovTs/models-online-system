package com.models.online.system.download.service.dataaccess.category.repository;

import com.models.online.system.download.service.dataaccess.category.entity.CategoryEntity;
import com.models.online.system.download.service.dataaccess.category.entity.CategoryEntityId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CategoryJpaRepository extends JpaRepository<CategoryEntity, CategoryEntityId> {

    Optional<List<CategoryEntity>> findByCategoryIdAndModelIdIn(UUID categoryId, List<UUID> modelsIds);
}
