package com.lkhadirn.guava_cache_implementation.retrievers;

import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.lkhadirn.guava_cache_implementation.core.UserRetriever;
import com.lkhadirn.guava_cache_implementation.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class CachedUserRetriever implements UserRetriever {

    Logger logger = LoggerFactory.getLogger(CachedUserRetriever.class);

    public final LoadingCache<String, List<User>> loadingCache;

    public CachedUserRetriever(LoadingCache<String, List<User>> loadingCache) {
        this.loadingCache = loadingCache;
    }

    @Override
    public List<User> getAllUsers() {
        try {
            return loadingCache.get("users");
        } catch (ExecutionException e) {
            logger.error("Error while retrieving users from cache", e);
            throw new RuntimeException(e);
        }
    }

    public static class UserCacheLoader extends CacheLoader<String, List<User>> {

        public final UserRetriever userRetriever;

        public UserCacheLoader(UserRetriever userRetriever) {
            this.userRetriever = userRetriever;
        }

        @Override
        public List<User> load(String key) {
            return userRetriever.getAllUsers();
        }
    }
}
