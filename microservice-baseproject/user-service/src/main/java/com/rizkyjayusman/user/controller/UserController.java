package com.rizkyjayusman.user.controller;

import com.rizkyjayusman.user.dto.LoginRequest;
import com.rizkyjayusman.user.dto.LoginResponse;
import com.rizkyjayusman.user.dto.RegisterRequest;
import com.rizkyjayusman.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public void register(@RequestBody RegisterRequest request) {
        userService.register(request);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return userService.login(request);
    }

    @GetMapping("/{userId}/validate")
    public boolean validateUser(@PathVariable Long userId) {
        return userService.validateUser(userId);
    }
}
