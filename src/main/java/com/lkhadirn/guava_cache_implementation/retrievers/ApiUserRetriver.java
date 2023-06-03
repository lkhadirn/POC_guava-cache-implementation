package com.lkhadirn.guava_cache_implementation.retrievers;

import com.lkhadirn.guava_cache_implementation.core.UserRetriever;
import com.lkhadirn.guava_cache_implementation.models.User;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

public class ApiUserRetriver implements UserRetriever {

    private final WebClient webClient;

    public ApiUserRetriver(WebClient.Builder builder) {
        webClient = builder.baseUrl("https://jsonplaceholder.typicode.com").build();
    }
    @Override
    public List<User> getAllUsers() {
        return webClient.get()
                .uri("/Users")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<User>>() {})
                .block();
    }
}
