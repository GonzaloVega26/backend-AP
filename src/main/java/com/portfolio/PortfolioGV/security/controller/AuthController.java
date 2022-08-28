/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.PortfolioGV.security.controller;

import com.portfolio.PortfolioGV.security.jwt.JwtProvider;
import com.portfolio.PortfolioGV.security.service.RoleService;
import com.portfolio.PortfolioGV.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.portfolio.PortfolioGV.security.dto.JwtDTO;
import com.portfolio.PortfolioGV.security.dto.LoginUser;
import com.portfolio.PortfolioGV.security.dto.NewUser;
import com.portfolio.PortfolioGV.security.entity.Role;
import com.portfolio.PortfolioGV.security.entity.User;
import com.portfolio.PortfolioGV.security.enums.RoleEnum;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gonzalo
 */
@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
    @Autowired PasswordEncoder passwordEncoder;
    @Autowired AuthenticationManager authenticationManager;
    @Autowired UserService userService;
    @Autowired RoleService roleService;
    @Autowired JwtProvider jwtProvider;
    
    @PostMapping("/create-user")
    public ResponseEntity<?> createUser(@Valid @RequestBody NewUser newUser, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return new ResponseEntity(new PMessage("Incorrect Data"),HttpStatus.BAD_REQUEST);
        if(userService.existByEmail(newUser.getEmail()))
            return new ResponseEntity(new PMessage("Email already in Use"),HttpStatus.BAD_REQUEST);
        User user = new User(newUser.getName(), newUser.getEmail(), passwordEncoder.encode(newUser.getPassword()));
        Set<Role> roles =new HashSet<>();
        //roles.add(roleService.getByRoleName(RoleEnum.ROLE_USER).get());
        //if(newUser.getRoles().contains("admin")) roles.add(roleService.getByRoleName(RoleEnum.ROLE_ADMIN).get());
        
        roles.add(roleService.getByRoleName(RoleEnum.ROLE_ADMIN).get()); //All users will be created as admins, cause there will be only one
        user.setRoles(roles);
        userService.saveUser(user);
        
        return new ResponseEntity(new PMessage("User Created"),HttpStatus.CREATED);
        
    }
    
    @PostMapping("/login")
    public ResponseEntity<JwtDTO> login (@Valid @RequestBody LoginUser loginUser, BindingResult bindingResult ){
        if(bindingResult.hasErrors()) return new ResponseEntity(new PMessage("Error in fields"),HttpStatus.BAD_REQUEST);
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginUser.getEmail(), loginUser.getPassword()));
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        JwtDTO  jwtDto = new JwtDTO(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
}
