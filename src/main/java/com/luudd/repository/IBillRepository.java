package com.luudd.repository;

import com.luudd.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Do Duc Luu on 1/7/2020.
 */
@Repository
public interface IBillRepository extends JpaRepository<Bill, Integer> {
}
