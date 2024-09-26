package com.springboot3security.Service;


import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.security.core.userdetails.UserDetails; 
import org.springframework.security.core.userdetails.UserDetailsService; 
import org.springframework.security.core.userdetails.UsernameNotFoundException; 
import org.springframework.security.crypto.password.PasswordEncoder; 
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.springboot3security.Entity.UserInfo;
import com.springboot3security.Repository.RoleRepository;
import com.springboot3security.Repository.UserInfoRepository;

import java.util.List;
import java.util.Optional; 

@Service
public class UserInfoService implements UserDetailsService { 
  
    @Autowired
    private UserInfoRepository repository; 
    
    @Autowired
    private RoleRepository repositorys;
  
    @Autowired
    private PasswordEncoder encoder; 
    
    
  
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { 
  
        Optional<UserInfo> userDetail = repository.findByName(username); 
  
        // Converting userDetail to UserDetails 
        return userDetail.map(UserInfoDetails::new) 
                .orElseThrow(() -> new UsernameNotFoundException("User not found " + username)); 
    } 
  
    public String addUser(UserInfo userInfo) { 
        userInfo.setPassword(encoder.encode(userInfo.getPassword())); 
        repository.save(userInfo); 
        return "User Added Successfully"; 
    } 
    
    
    public UserInfo getUserById(int id) {
        Optional<UserInfo> userOptional = Optional.ofNullable(repository.findById(id));
        return userOptional.orElse(null);
    }
    
    public List<UserInfo> getAllUsers() {
        return repository.findAll();
    }
  
} 