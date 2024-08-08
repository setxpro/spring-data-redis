package com.github.setxpro.spring_db_redis_cache.controller;

import com.github.setxpro.spring_db_redis_cache.entity.Subscribe;
import com.github.setxpro.spring_db_redis_cache.service.SubscribeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("subscribe")
@RequiredArgsConstructor
public class SubscribeController {

    private final SubscribeService service;

    @GetMapping("/{id}")
    public ResponseEntity<Subscribe> getSubscribe(@PathVariable Long id) {
        Subscribe subscribe = service.getSubscribe(id);
        return subscribe != null ? ResponseEntity.ok(subscribe) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Subscribe>> getAllSubscribes() {
        List<Subscribe> subscribe = service.getAllSubscribes();
        return ResponseEntity.ok(subscribe);
    }

    @PostMapping
    public ResponseEntity<Subscribe> creteSubscribe(@RequestBody Subscribe subscribe) {
        Subscribe saveSubscribe = service.saveUser(subscribe);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveSubscribe);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubscribe(@PathVariable Long id) {
        service.deleteSubscribe(id);
        return ResponseEntity.noContent().build();
    }

}
