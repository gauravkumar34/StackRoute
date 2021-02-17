package com.stackroute.MongoCrud.services;

import com.stackroute.MongoCrud.model.User;
import com.stackroute.MongoCrud.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class UserServiceCacheTest {
    @Mock
    private UserRepository userRepository;
    @Autowired
    @InjectMocks
    private UserServiceImpl userService;
    private User user1;
    private User user2;
    private List<User> userList;

    @BeforeEach
    public void setUp() {
        userList = new ArrayList<>();
        user1 = new User(1,"John","Singh",24);
        user2 = new User(2,"Gaurav","Singh",27);
        userList.add(user1);
        userList.add(user2);
    }
    @AfterEach
    public void tearDown() {
        user1 = user2 =null;
        userList =null;
    }

    @Test
    void givenCallToGetAllUserThenShouldReturnListOfUsers() {
        userService.saveUser(user1);
        userService.saveUser(user2);
        userService.getAllUsers();
        userService.getAllUsers();
        userService.getAllUsers();
        userService.getAllUsers();
        verify(userRepository,times(1)).findAll();
    }

    @Test
    void givenUserIdThenShouldReturnUserWithThatId() {
        when(userRepository.findById(anyInt())).thenReturn(Optional.of(user1));
        userService.saveUser(user1);
        userService.saveUser(user2);
        userService.getUserById(user1.getId());
        userService.getUserById(user1.getId());
        verify(userRepository, times(1)).findById(user1.getId());
    }

    @Test
    void givenUserToSaveThenShouldEvictCache() {
        when(userRepository.save(any())).thenReturn(user1);
        when(userRepository.findById(anyInt())).thenReturn(Optional.of(user1));
        userService.saveUser(user1);
        userService.getUserById(user1.getId());
        userService.getUserById(user1.getId());
        verify(userRepository, times(1)).findById(user1.getId());
    }
    @Test
    void givenUserToDeleteThenShowEvictCache() {
        userService.saveUser(user1);
        userService.saveUser(user2);
        userService.deleteUser(1);
        userService.getAllUsers();
        userService.getAllUsers();
        userService.getAllUsers();
        userService.getAllUsers();
    verify(userRepository, times(1)).findAll();
    }

    @Test
    void givenUserToUpdateThenShouldEvictCache() {
        userService.saveUser(user1);
        userService.saveUser(user2);
        userService.updateUser(user1);
        user1.setFirstName("Samle User");
        userService.getAllUsers();
        userService.getAllUsers();
        userService.getAllUsers();
        userService.getAllUsers();
        verify(userRepository, times(1)).findAll();

    }





}
