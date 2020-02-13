package ro.iteahome.eLibrary.service;

import ro.iteahome.eLibrary.dao.UserDao;
import ro.iteahome.eLibrary.exception.LibraryException;
import ro.iteahome.eLibrary.model.User;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @org.junit.jupiter.api.Test
    void login() {
        UserService userService = new UserService();
        List<User> userList = new ArrayList<>();
        User user1= new User(1,"ovi13","ovi12","ovi123",2);
        userList.add(user1);

        try {
            assertEquals("ovidiu", userService.login("ovidiu","todea").getName());
            assertNotEquals("ovi", userService.login("ovidiu","todea").getName());
        } catch (LibraryException e) {
            e.printStackTrace();
        }

    }

}