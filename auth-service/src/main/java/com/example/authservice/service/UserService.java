package com.example.authservice.service;

import com.example.authservice.dto.request.RegisterRequest;
import com.example.authservice.dto.response.RegisterResponse;
import com.example.authservice.entity.UserEntity;
import com.example.authservice.enums.Role;
import com.example.authservice.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegisterResponse registerUser(RegisterRequest request) {
        String email = request.getEmail();
        String userName = request.getUsername();
        String password = request.getPassword();
        String role = request.getRole();
        String firstName = request.getFirstName();
        String lastName = request.getLastName();

        Optional<UserEntity> userEntityByEmail = userRepository.findByEmail(email);
        Optional<UserEntity> userEntityByUsername = userRepository.findByUsername(userName);

        if (userEntityByEmail.isPresent() || userEntityByUsername.isPresent()) {
            return RegisterResponse.builder()
                    .status(HttpStatus.BAD_REQUEST.value())
                    .message("User already exists!")
                    .build();
        }

        UserEntity userEntity = UserEntity.builder()
                .username(userName)
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .password(passwordEncoder.encode(password)) // Password should be encoded in a real application
                .role(Role.toEnum(role)) // Assuming role is a string, you might want to convert it to an enum
                .build();

        userRepository.save(userEntity);

        return RegisterResponse.builder()
                .status(HttpStatus.OK.value())
                .message("User created successfully")
                .build();
    }

}

