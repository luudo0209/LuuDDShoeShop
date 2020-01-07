package com.luudd.repository;

import com.luudd.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Do Duc Luu on 1/7/2020.
 */
public interface IProductImageRepository extends JpaRepository<ProductImage, Integer> {
}
