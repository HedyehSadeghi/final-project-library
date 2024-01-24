package org.learning.finalprojectlibrary.repository;

import org.learning.finalprojectlibrary.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
