package com.lkhadirn.guava_cache_implementation;

import com.lkhadirn.guava_cache_implementation.core.CacheStore;
import com.lkhadirn.guava_cache_implementation.models.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Configuration
public class Config {

    @Bean
    public CacheStore<List<User>> allUsersCacheStore() {
        return new CacheStore<>(120, TimeUnit.SECONDS);
    }
}