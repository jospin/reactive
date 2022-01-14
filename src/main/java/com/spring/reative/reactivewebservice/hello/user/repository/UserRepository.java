package com.spring.reative.reactivewebservice.hello.user.repository;

import com.spring.reative.reactivewebservice.hello.user.model.UserSystem;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface UserRepository extends ReactiveCrudRepository<UserSystem, Long> {

    @Query("SELECT * FROM user_system WHERE username = :username")
    Flux<UserSystem> findByUsername(String username);

}
