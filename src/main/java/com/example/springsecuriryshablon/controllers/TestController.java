package com.example.springsecuriryshablon.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class TestController {

    @GetMapping("/")
    public String allRole() {

        return "All role ";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/admin")
    public String adminOnly() {
        return "Admin only!";
    }
    @GetMapping("/onlyauth")
public String onlyAuthentication() {
        return "Ony Authentication";
    }
    }
