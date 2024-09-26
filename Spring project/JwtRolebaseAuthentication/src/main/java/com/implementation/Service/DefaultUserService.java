package com.implementation.Service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.implementation.Entity.User;
import com.implementation.Entity.UserDTO;



public interface DefaultUserService extends UserDetailsService{
	User save(UserDTO userRegisteredDTO);

}
