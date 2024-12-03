package org.yassir.ebanking.Controller;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SecureController {
    @GetMapping("/myAccount")
    public String  getAccountInfo(Authentication authentication) {
        return "Account details for user";
    }

    @GetMapping("/myLoans")
    public String getLoans(Authentication authentication) {
        return "myLoans";
    }


    @GetMapping("/myCards")
    public String getMyCards(Authentication authentication) {
        return "My cards";
    }


}
