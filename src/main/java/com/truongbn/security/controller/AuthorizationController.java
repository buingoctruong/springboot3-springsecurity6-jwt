package com.truongbn.security.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/resource")
@RequiredArgsConstructor
public class AuthorizationController {
    @GetMapping
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Here is your resource");
    }

    @GetMapping("/welcomeAdmin")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String welcome() {
        return "Welcome Admin";
    }

    @GetMapping("/welcomeUser")
    @PreAuthorize("hasAuthority('USER')")
    public String welcomeUser() {
        return "Welcome USER";
    }
}
