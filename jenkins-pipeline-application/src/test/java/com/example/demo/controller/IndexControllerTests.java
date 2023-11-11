package com.example.demo.controller;

import com.example.demo.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import org.mockito.ArgumentCaptor;

@ExtendWith(MockitoExtension.class)

class IndexControllerTest {

    @Test

    void testindex() {

        IndexController indexController = new IndexController();

        String result = indexController.index();

        assertEquals("index", result);

    }

    @Test

    void testUserLogin() {

        IndexController indexController = new IndexController();

        User user = new User();

        user.setFname("John");

        user.setLname("Doe");

        Model model = mock(Model.class);

        String result = indexController.userLogin(user, model);

        assertEquals("welcome", result);

        ArgumentCaptor<String> captorFirstName = ArgumentCaptor.forClass(String.class);

        ArgumentCaptor<String> captorLastName = ArgumentCaptor.forClass(String.class);

        verify(model, times(2)).addAttribute(anyString(), captorFirstName.capture());

        verify(model, times(2)).addAttribute(anyString(), captorLastName.capture());

        assertEquals("John", captorFirstName.getAllValues().get(0));

        assertEquals("Doe", captorLastName.getAllValues().get(1));

        // Add more assertions for other attributes if necessary

    }

}
