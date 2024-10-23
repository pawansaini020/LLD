package com.pawan.LLD.lld.authentication.Controller;

import com.pawan.LLD.lld.authentication.dto.UserAccessDTO;
import com.pawan.LLD.lld.authentication.service.UserAccessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/authentication/api/v1/user-access")
public class UserAccessController {

    private final UserAccessService userAccessService;

    public UserAccessController(UserAccessService userAccessService) {
        this.userAccessService = userAccessService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addUserRole(@RequestParam(value = "user_name") String userName,
                                         @RequestParam(value = "password") String password,
                                         @RequestParam(value = "expiry_time") Long expiryTime,
                                         @RequestParam(value = "role") String role) {
        userAccessService.addClient(userName, password, expiryTime, role);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<?> getUserAccessDetails(@RequestParam(value = "user_name") String userName) {
        return new ResponseEntity<>(userAccessService.getUserAccessDetails(userName), HttpStatus.OK);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<?> deleteUserRole(@RequestParam(value = "user_name") String userName) {
        userAccessService.deleteUserRole(userName);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/get-role")
    public ResponseEntity<?> getUserRole(@RequestParam("user_name") String username) {
        // Load the user details
        UserAccessDTO userDetails = userAccessService.getUserAccessDetails(username);

        // Extract the authorities (roles)
        Collection<? extends GrantedAuthority> authorities = userDetails.getRoles();

        // Return roles as a response
        List<String> roles = authorities.stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return ResponseEntity.ok(roles);
    }
}
