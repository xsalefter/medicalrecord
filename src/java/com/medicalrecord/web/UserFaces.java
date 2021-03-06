/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medicalrecord.web;

import com.medicalrecord.model.Role;
import com.medicalrecord.model.User;
import com.medicalrecord.service.RoleService;
import com.medicalrecord.service.UserService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Retna P
 */
@Named(value = "userFaces")
@RequestScoped
public class UserFaces {
    @EJB
    private UserService userService;
    
    @EJB
    private RoleService roleService;
    
    private User user;
    private Role role;
    private List<Role> roles;
    
    @PostConstruct
    public void postConstruct() {
        if (this.user == null) this.user = new User();
        if (this.role == null) this.role = new Role();
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    
    public void addUser(){
        System.out.println(" " +user + role.getId());
        
        this.userService.save(this.user, this.role.getId());
        
        user = new User();
    }
    
    public void deleteUser(User user){
        this.userService.delete(user);
    }
    
    public List<Role> getRoles(){ 
        this.roles = roleService.findAll();
        return this.roles;
    }
    
    public List<User> getFindAll(){
        return userService.findAll();
    }
}
