package com.springboot3security.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot3security.Entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
