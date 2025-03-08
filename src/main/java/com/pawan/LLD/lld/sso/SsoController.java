package com.pawan.LLD.lld.sso;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sso")
@Slf4j
public class SsoController {

    @GetMapping(value = "/login")
    public ResponseEntity<String> homePage() {
        return ResponseEntity.ok("SSO Login is success.");
    }
}
