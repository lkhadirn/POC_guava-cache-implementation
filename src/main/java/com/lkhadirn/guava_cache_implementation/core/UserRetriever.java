package com.lkhadirn.guava_cache_implementation.core;

import com.lkhadirn.guava_cache_implementation.models.User;

import java.util.List;

public interface UserRetriever {
    List<User> getAllUsers();
}
