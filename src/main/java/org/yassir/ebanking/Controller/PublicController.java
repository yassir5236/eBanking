package org.yassir.ebanking.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PublicController {

    @GetMapping("/notices")
    public String notices(){
        return "Annonce generale";
    }

    @GetMapping("/contact")
    public String contact(){
        return " Contact du support client";
    }



}
