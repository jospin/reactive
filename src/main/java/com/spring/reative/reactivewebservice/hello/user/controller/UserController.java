package com.spring.reative.reactivewebservice.hello.user.controller;

import com.spring.reative.reactivewebservice.hello.user.model.UserSystem;
import com.spring.reative.reactivewebservice.hello.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("hello/user")
@Slf4j
public class UserController {
    private final UserRepository repository;

    @Autowired
    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/list")
    public Flux<UserSystem> list() {
        log.info("call list user");
        return repository.findAll();
    }
}
