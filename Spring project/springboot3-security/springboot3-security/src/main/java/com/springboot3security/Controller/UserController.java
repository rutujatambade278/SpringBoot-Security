package com.springboot3security.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot3security.Entity.AuthRequest;
import com.springboot3security.Entity.UserInfo;
import com.springboot3security.Repository.UserInfoRepository;
import com.springboot3security.Service.JwtService;
import com.springboot3security.Service.UserInfoService;



@RestController
//@CrossOrigin("*")
@RequestMapping("/auth") 
public class UserController { 
  
    @Autowired
    private UserInfoService service; 
  
    @Autowired
    private JwtService jwtService; 
  
    @Autowired
    private AuthenticationManager authenticationManager; 
    
    
    @Autowired
    private UserInfoRepository repository; 
    
    @Autowired
    public UserController(UserInfoService service) {
        this.service = service;
    }
  
    
    
    @Autowired
    public void setService(UserInfoService service) {
        this.service = service;
    }
    
    @GetMapping("/welcome") 
    public String welcome() { 
        return "Welcome page display"; 
    } 
  
    @GetMapping("/home") 
    public String home() { 
        return "home page display"; 
    } 
  
    @GetMapping("/users/{id}")
    public ResponseEntity<UserInfo> getUserById(@PathVariable int id) {
        UserInfo user = service.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/users")
  //  @PreAuthorize("hasAuthority('ROLE_USER')") 
    public ResponseEntity<List<UserInfo>> getAllUsers() {
        List<UserInfo> users = service.getAllUsers();
        if (!users.isEmpty()) {
            return ResponseEntity.ok(users);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }
    
    @PostMapping("/addNewUser") 
    public String addNewUser(@RequestBody UserInfo userInfo) { 
        return service.addUser(userInfo); 
    } 
  
    @GetMapping(""+ "") 
    @PreAuthorize("hasAuthority('ROLE_USER')") 
    public String userProfile() { 
        return "Welcome to User Profile"; 
    } 
  
    @GetMapping("/admin/adminProfile") 
    @PreAuthorize("hasAuthority('ROLE_ADMIN')") 
    public String adminProfile() { 
        return "Welcome to Admin Profile"; 
    } 
  
    @PostMapping("/generateToken") 
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) { 
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())); 
        if (authentication.isAuthenticated()) { 
            return jwtService.generateToken(authRequest.getUsername()); 
        } else { 
            throw new UsernameNotFoundException("invalid user request !"); 
        } 
    } 
    

	
} 