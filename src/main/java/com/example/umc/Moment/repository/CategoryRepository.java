package com.example.umc.Moment.repository;

import com.example.umc.Moment.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
