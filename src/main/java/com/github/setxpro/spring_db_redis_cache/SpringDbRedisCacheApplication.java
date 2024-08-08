package com.github.setxpro.spring_db_redis_cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringDbRedisCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDbRedisCacheApplication.class, args);
	}

}
