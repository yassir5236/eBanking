package org.yassir.ebanking.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/eBanking")
public class TestController {

    @GetMapping("/test")
    public String test1() {
        return "test";
    }
}
