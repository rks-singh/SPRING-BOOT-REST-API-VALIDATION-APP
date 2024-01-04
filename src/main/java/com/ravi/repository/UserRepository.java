package com.ravi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ravi.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
