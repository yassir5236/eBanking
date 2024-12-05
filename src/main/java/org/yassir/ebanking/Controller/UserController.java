package org.yassir.ebanking.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yassir.ebanking.DTO.PasswordChangeRequest;
import org.yassir.ebanking.Model.Entity.User;
import org.yassir.ebanking.Service.UserService;

import java.util.List;

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





    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        User user = userService.getUserByUsername(username).orElse(null);
        return ResponseEntity.ok(user);
    }


    @DeleteMapping("/{username}")
    public ResponseEntity<?> deleteUser(@PathVariable String username) {
        userService.deleteUser(username);
        return ResponseEntity.ok("Utilisateur supprimé avec succès");
    }

    // 4. Endpoint pour mettre à jour le rôle d'un utilisateur (ADMIN)
    @PutMapping("/{username}/updateRole")
    public ResponseEntity<?> updateUserRole(@PathVariable String username, @RequestParam String newRole) {
        userService.updateUserRole(username, newRole);
        return ResponseEntity.ok("Rôle de l'utilisateur mis à jour avec succès");
    }
}

