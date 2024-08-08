package com.github.setxpro.spring_db_redis_cache.repository;

import com.github.setxpro.spring_db_redis_cache.entity.Subscribe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscribeRepository extends JpaRepository<Subscribe, Long> {
}
