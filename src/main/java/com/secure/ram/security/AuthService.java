package com.secure.ram.security;

import com.secure.ram.dto.LoginRequestDto;
import com.secure.ram.dto.LoginResponseDto;
import com.secure.ram.dto.SignUpResponseDto;
import com.secure.ram.entity.User;
import lombok.AllArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final AuthUtil authUtil;

    private final AuthenticationManager authenticationManager;

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public AuthService(AuthUtil authUtil, AuthenticationManager authenticationManager, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.authUtil = authUtil;
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }



    public @Nullable LoginResponseDto login(LoginRequestDto loginRequestDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(), loginRequestDto.getPassword()));
        User user = (User) authentication.getPrincipal();
        String token = authUtil.generateAccessToken(user);
        return new LoginResponseDto(token, user.getId());

    }

    public @Nullable SignUpResponseDto signUp(LoginRequestDto loginRequestDto) {
        Optional<User> user = userRepository.findByUsername(loginRequestDto.getUsername());
        if(user.isPresent()) throw new RuntimeException("user already exist");
       User save =  userRepository.save(new User(loginRequestDto.getUsername(),passwordEncoder.encode(loginRequestDto.getPassword())));
        return new SignUpResponseDto(save.getId(), save.getUsername());

    }
}
