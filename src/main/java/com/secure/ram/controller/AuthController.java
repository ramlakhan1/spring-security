package com.secure.ram.controller;

import com.secure.ram.dto.LoginRequestDto;
import com.secure.ram.dto.LoginResponseDto;
import com.secure.ram.dto.SignUpResponseDto;
import com.secure.ram.security.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto){
       return  ResponseEntity.ok(authService.login(loginRequestDto));
    }

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseDto> signUp(@RequestBody LoginRequestDto loginRequestDto){
        return ResponseEntity.ok(authService.signUp(loginRequestDto));
    }
}
