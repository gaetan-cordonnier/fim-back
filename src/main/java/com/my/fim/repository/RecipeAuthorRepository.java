package com.my.fim.repository;

import com.my.fim.model.RecipeAuthor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeAuthorRepository extends JpaRepository<RecipeAuthor, Long> {
}
