package com.luudd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luudd.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

}
