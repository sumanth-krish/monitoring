package com.example.springBootMonitoring;

import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Timed
public class Controller {

    @Autowired
    service service;

    @GetMapping("/")
    @Timed("api")
    public Number index() {

        return service.fetchActiveUsers();
    }

    @PostMapping("/phones")
    @Timed("phones.api")
    public String orderPhone() {
        return service.orderPhone();
    }

    @PostMapping("/watch")
    @Timed("watch.api")
    public String orderWatch() {
        return service.orderWatch();
    }
}
