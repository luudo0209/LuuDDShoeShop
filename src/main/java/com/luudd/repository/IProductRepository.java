package com.luudd.repository;

import com.luudd.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Do Duc Luu on 1/3/2020.
 */
@Repository
public interface IProductRepository  extends JpaRepository<Product, Integer>{
    @Query(nativeQuery = true , value = "SELECT * FROM product WHERE product_id = :product_id")
    Product getProductById(@Param("product_id") int id);

    @Query(nativeQuery = true , value = "SELECT * FROM product")
    List<Product> getAllProducts();
}
