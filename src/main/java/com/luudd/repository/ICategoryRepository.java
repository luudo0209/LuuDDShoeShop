package com.luudd.repository;

import com.luudd.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Do Duc Luu on 1/5/2020.
 */
@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer> {
    @Query(nativeQuery = true , value = "SELECT * FROM category WHERE category_id = :id_category")
    Category getCategoryById(@Param("id_category") Long id);

}
