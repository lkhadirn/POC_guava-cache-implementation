package com.lkhadirn.guava_cache_implementation.retrievers;

import com.lkhadirn.guava_cache_implementation.core.CacheStore;
import com.lkhadirn.guava_cache_implementation.core.UserRetriever;
import com.lkhadirn.guava_cache_implementation.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("cachedUserRetriever")
public class CachedUserRetriever implements UserRetriever {

    @Autowired()
    public final CacheStore<List<User>> cacheStore;

    public CachedUserRetriever(@Qualifier("allUsersCacheStore") CacheStore<List<User>> cacheStore) {
        this.cacheStore = cacheStore;
    }

    @Override
    public List<User> getAllUsers() {
        return cacheStore.get("users");
    }
}
