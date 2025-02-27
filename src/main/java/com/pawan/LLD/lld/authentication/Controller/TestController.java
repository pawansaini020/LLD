package com.pawan.LLD.lld.authentication.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController {

    @GetMapping(value = "/ping")
    public ResponseEntity<String> homePage() {
        return ResponseEntity.ok("pong");
    }
}
