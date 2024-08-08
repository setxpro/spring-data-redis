package com.github.setxpro.spring_db_redis_cache.service;

import com.github.setxpro.spring_db_redis_cache.config.RedisConfig;
import com.github.setxpro.spring_db_redis_cache.entity.Subscribe;
import com.github.setxpro.spring_db_redis_cache.repository.SubscribeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SubscribeService {
    private final SubscribeRepository subscribeRepository;


    @Cacheable(value = RedisConfig.KEY_SUBSCRIBE, key = "#id")
    public Subscribe getSubscribe(Long id) {
        clearCache();
        return subscribeRepository.findById(id).orElse(null);
    }

    @Cacheable(value = RedisConfig.KEY_SUBSCRIBE)
    public List<Subscribe> getAllSubscribes() {
        List<Subscribe> subscribes = subscribeRepository.findAll();
        System.out.println("Fetching from database: " + subscribes);
        return subscribes;
    }

    @CachePut(value = RedisConfig.KEY_SUBSCRIBE, key = "#subscribe.id")
    public Subscribe saveUser(Subscribe subscribe) {
        clearCache();
        return subscribeRepository.save(subscribe);
    }

    @CacheEvict(value = RedisConfig.KEY_SUBSCRIBE, key = "#id")
    public void deleteSubscribe(Long id) {
        subscribeRepository.deleteById(id);
    }

    @CacheEvict(allEntries = true, value = RedisConfig.KEY_SUBSCRIBE)
    public void clearCache() {
        // This will clear the cache for KEY_SUBSCRIBE
        log.info("Cache cleared");
    }

}
