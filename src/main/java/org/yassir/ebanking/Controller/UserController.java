package org.yassir.ebanking.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yassir.ebanking.DTO.PasswordChangeRequest;
import org.yassir.ebanking.Model.Entity.User;
import org.yassir.ebanking.Service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        userService.registerUser(user);
        return ResponseEntity.ok("User registered successfully");
    }


    @PutMapping("/{username}")
    public ResponseEntity<?> updatePassword(@PathVariable String username, @RequestBody PasswordChangeRequest passwordChangeRequest) {
        try {
            userService.updatePassword(username, passwordChangeRequest.oldPassword(), passwordChangeRequest.newPassword());
            return ResponseEntity.ok("Mot de passe mis à jour avec succès");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}

