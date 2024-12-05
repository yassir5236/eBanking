package org.yassir.ebanking.Controller;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/secure")
public class SecureController {
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

}
