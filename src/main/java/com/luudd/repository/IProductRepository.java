package com.luudd.repository;

import com.luudd.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Do Duc Luu on 1/3/2020.
 */
@Repository
public interface IProductRepository  extends JpaRepository<Product, Integer>{
}
