package com.implementation.Entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class User {

	   @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private int id;

	    private String userName;
	    private String password;
	    private String email;

	    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    @JoinTable(name = "users_role",
	            joinColumns = @JoinColumn(name = "user_id"),
	            inverseJoinColumns = @JoinColumn(name = "role_id"))
	    Set<Role> roles = new HashSet<>();

	    
	    public User() {
	    }

	    public User(String userName, String password, String email) {
	        this.userName = userName;
	        this.password = password;
	        this.email = email;
	    }

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getUserName() {
	        return userName;
	    }

	    public void setUserName(String userName) {
	        this.userName = userName;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public Set<Role> getRoles() {
	        return roles;
	    }

	    public void setRoles(Role role) {
	        this.roles.add(role);
	    }

	    @Override
	    public String toString() {
	        return "User{" +
	                "id=" + id +
	                ", userName='" + userName + '\'' +
	                ", password='" + password + '\'' +
	                ", email='" + email + '\'' +
	                ", roles=" + roles +
	                '}';
	    }
}