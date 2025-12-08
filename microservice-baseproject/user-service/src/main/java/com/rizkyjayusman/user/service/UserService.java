package com.rizkyjayusman.user.service;

import com.rizkyjayusman.user.dto.LoginRequest;
import com.rizkyjayusman.user.dto.LoginResponse;
import com.rizkyjayusman.user.dto.RegisterRequest;
import com.rizkyjayusman.user.entity.User;
import com.rizkyjayusman.user.repository.UserRepository;
import com.rizkyjayusman.user.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void register(RegisterRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }
        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        userRepository.save(user);
    }

    public LoginResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtUtil.generateToken(user.getId());
        return LoginResponse.builder().token(token).build();
    }

    public boolean validateUser(Long userId) {
        return userRepository.existsById(userId);
    }
}
