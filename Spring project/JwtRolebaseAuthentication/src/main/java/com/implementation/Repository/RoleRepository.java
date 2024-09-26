package com.implementation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.implementation.Entity.Role;



public interface RoleRepository extends JpaRepository<Role, Integer> {
	Role findByRole(String role);

}
