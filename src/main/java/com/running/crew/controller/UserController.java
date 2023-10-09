package com.running.crew.controller;


import com.running.crew.domain.user.UserService;
import com.running.crew.domain.user.model.SignupRequest;
import com.running.crew.domain.user.model.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    @Operation(summary = "내 정보를 가져옵니다.")
    public UserResponse me(@RequestBody SignupRequest request) {
        return UserResponse.from(userService.signup(request));
    }

    @GetMapping("/{userId}")
    @Operation(summary = "내 정보를 가져옵니다.")
    public UserResponse me(@PathVariable Long userId) {
        return UserResponse.from(userService.findById(userId));
    }
}
