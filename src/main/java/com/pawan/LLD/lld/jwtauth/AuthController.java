package com.pawan.LLD.lld.jwtauth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username,
                                        @RequestParam String password) {
        String token = jwtUtil.generateToken(username, password);
        return ResponseEntity.ok(token);
    }


    @GetMapping("/user/info")
    public ResponseEntity<String> userInfo(@RequestParam String username) {
        return ResponseEntity.ok(username);
    }
}
