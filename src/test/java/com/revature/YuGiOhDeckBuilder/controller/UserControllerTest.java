package com.revature.YuGiOhDeckBuilder.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.revature.YuGiOhDeckBuilder.model.User;
import com.revature.YuGiOhDeckBuilder.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserControllerTest {

    @Mock
    UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    public void contextLoads() {
        assertThat(userController).isNotNull();
    }

    @Test
    public void getAllUsersTest_positive() {
        List<User> userList = userController.getAllUsers();
        assertThat(userList).isNotNull();
    }

    @Test
    public void getUserByUsernameTest_positive() {
        User expected = new User(1, "test", "password", "test", "test", "test@test.com", "user");
        when(userService.getUserByUsername("test")).thenReturn(expected);
        User user = userController.getUserByUsername("test");
        assertThat(user).isEqualTo(expected);
    }
    @Test
    public void getUserByIdTest_positive() {
        User user = new User(1, "test", "password", "test", "test", "test@test.com", "user");
        when(userService.getUserById(1)).thenReturn(user);
        User actual = userController.getUserById(1);
        assertThat(actual).isEqualTo(user);
    }
}
