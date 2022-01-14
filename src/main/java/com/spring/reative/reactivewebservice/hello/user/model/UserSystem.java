package com.spring.reative.reactivewebservice.hello.user.model;

import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@Setter

public class UserSystem {

    @Id
    private Long id;
    @NonNull
    private final String username;

    public UserSystem(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
