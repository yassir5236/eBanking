package org.yassir.ebanking.Controller;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yassir.ebanking.DTO.PasswordChangeRequest;
import org.yassir.ebanking.Service.UserService;

import java.security.Principal;

@RestController
@RequestMapping("/api/secure")
public class SecureController {

    @Autowired
    private UserService userService;


    @GetMapping("/myAccount")
    public String  getAccountInfo() {
        return "Account details for user";
    }

    @GetMapping("/myLoans")
    public String getLoans() {
        return "myLoans";
    }


    @GetMapping("/myCards")
    public String getMyCards() {
        return "My cards";
    }


    @GetMapping("/myBalance")
    public String myBalance() {
        return "myBalance";
    }


//    @PutMapping("/{username}")
//    public ResponseEntity<?> updatePassword(@PathVariable String username, @RequestBody PasswordChangeRequest passwordChangeRequest) {
//        try {
//            userService.updatePassword(username, passwordChangeRequest.oldPassword(), passwordChangeRequest.newPassword());
//            return ResponseEntity.ok("Mot de passe mis à jour avec succès");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//        }
//    }


    @PutMapping("/{username}")
    public ResponseEntity<?> updatePassword(
            @PathVariable String username,
            @RequestBody PasswordChangeRequest passwordChangeRequest,
            Principal principal) {
        String authenticatedUsername = principal.getName();

        if (!username.equals(authenticatedUsername)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Unauthorized: le username dans l'URL ne correspond pas à l'utilisateur authentifié.");
        }

        try {
            userService.updatePassword(username, passwordChangeRequest.oldPassword(), passwordChangeRequest.newPassword());
            return ResponseEntity.ok("Mot de passe mis à jour avec succès");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


}
