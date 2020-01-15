package com.expense.report.repository;

import com.expense.report.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    Category save(Category category);
    void delete(Category category);
    Category findById(int id);
    List findAll();

    @Query("select c from Category c where c.name = :#{#categoryName}")
    Category findByName(@Param("categoryName") String categoryName);

}
