package com.aslihan.todoapp.service;

import com.aslihan.todoapp.entity.User;
import com.aslihan.todoapp.web.request.CreateUserRequest;

import javax.security.auth.message.AuthException;
import java.util.List;

public interface IUserService {
    User createUser(CreateUserRequest createUserRequest) throws AuthException;
    boolean deleteUser(Long userId);
    List<User> getAllUser();
    User getUserByUsernameAndPassword(String username, String password);

}
