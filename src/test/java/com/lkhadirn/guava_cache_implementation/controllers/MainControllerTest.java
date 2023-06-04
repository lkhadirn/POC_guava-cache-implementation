package com.lkhadirn.guava_cache_implementation.controllers;

import com.lkhadirn.guava_cache_implementation.core.UserRetriever;
import com.lkhadirn.guava_cache_implementation.models.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MainControllerTest {

    @Mock
    private UserRetriever userRetriever;
    @InjectMocks
    public MainController mainController;

    @Test
    void shouldGetAllUsers() {
        //given
        given(userRetriever.getAllUsers()).willReturn(Collections.singletonList(new User()));
        //when
        List<User> allUsers = mainController.getAllUsers();
        //then
        verify(userRetriever).getAllUsers();
        assertThat(allUsers).isNotEmpty();
    }
}