package com.konvergion.personalfinance.expenseplansapi.web;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
public class TokenController {

    @GetMapping
    public ResponseEntity<Jwt> getJwtToken(@AuthenticationPrincipal Jwt jwt){
        return ResponseEntity.ok(jwt);
    }
}
