package com.wawel.persistence.controllers;

import com.wawel.dto.LoginDto;
import com.wawel.dto.SignUpDto;
import com.wawel.entity.auth.Role;
import com.wawel.entity.auth.User;
import com.wawel.persistence.repositories.auth.RolesRepository;
import com.wawel.persistence.repositories.auth.UsersRepository;
import com.wawel.response.GeneralUserInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "*")
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

//    @Autowired
//    private JwtUtil jwtUtil;

    @PostMapping("/signin")
    public ResponseEntity<GeneralUserInfoResponse> authenticateUser(@RequestBody LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getUsernameOrEmail(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        User user = usersRepository.findByUsernameOrEmail(loginDto.getUsernameOrEmail(), loginDto.getUsernameOrEmail())
                .orElseThrow();
        GeneralUserInfoResponse response = GeneralUserInfoResponse.builder()
                .userId(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .roles(user.getRoles())
//                .token(jwtUtil.generateToken((UserDetails) authentication.getPrincipal())) // Add JWT token to response
                .build();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@RequestBody SignUpDto signUpDto) {
        if (Boolean.TRUE.equals(usersRepository.existsByUsername(signUpDto.getUsername()))) {
            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        }

        if (Boolean.TRUE.equals(usersRepository.existsByEmail(signUpDto.getEmail()))) {
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }

        User user = new User();
        user.setUsername(signUpDto.getUsername());
        user.setEmail(signUpDto.getEmail());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));

        Role roles = rolesRepository.findByName("ROLE_USER").orElseThrow();
        user.setRoles(Collections.singleton(roles));

        usersRepository.save(user);

        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }
}

