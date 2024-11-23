package org.sang;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/test")
    public String hello() {
        return "hello spring boot!";
    }

    @GetMapping("/test2")
    public String hello2() {
        return "hello  hi test 2!";
    }
}
