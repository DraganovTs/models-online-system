package com.models.online.system.download.service.domain.ports.output.repository;

import com.models.online.system.download.service.domain.entity.Category;

import java.util.Optional;

public interface CategoryRepository {

    Optional<Category> findCategoryInformation(Category category);

}
