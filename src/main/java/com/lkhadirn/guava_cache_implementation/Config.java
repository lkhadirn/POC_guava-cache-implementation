package com.lkhadirn.guava_cache_implementation;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;
import com.lkhadirn.guava_cache_implementation.core.UserRetriever;
import com.lkhadirn.guava_cache_implementation.models.User;
import com.lkhadirn.guava_cache_implementation.retrievers.ApiUserRetriver;
import com.lkhadirn.guava_cache_implementation.retrievers.CachedUserRetriever;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class Config {

    @Value("${cache.spec}")
    private String cacheSpec;

    @Bean
    public UserRetriever userRetriever() {
        ApiUserRetriver apiUserRetriver = new ApiUserRetriver();
        LoadingCache<String, List<User>> loadingCache = CacheBuilder.from(cacheSpec)
                .build(new CachedUserRetriever.UserCacheLoader(apiUserRetriver));
        return new CachedUserRetriever(loadingCache);
    }
}