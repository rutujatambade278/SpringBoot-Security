package com.implementation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.implementation.Entity.User;



public interface UserRepository extends JpaRepository<User, Integer>{
	User findByUserName(String username);
}
