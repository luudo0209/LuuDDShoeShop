package com.luudd.repository;

import com.luudd.entity.Product;
import com.luudd.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Do Duc Luu on 1/7/2020.
 */
@Repository
public interface IProductImageRepository extends JpaRepository<ProductImage, Integer> {
    @Query(nativeQuery = true , value = "SELECT * FROM product_image WHERE product_id = :product_id")
    List<ProductImage> getImagesByProductId(@Param("product_id") int id);
}
