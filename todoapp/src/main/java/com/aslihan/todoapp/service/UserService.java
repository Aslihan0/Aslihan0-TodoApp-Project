package com.aslihan.todoapp.service;

import com.aslihan.todoapp.entity.User;
import com.aslihan.todoapp.repository.UserRepository;
import com.aslihan.todoapp.web.request.CreateUserRequest;
import org.springframework.stereotype.Service;

import javax.security.auth.message.AuthException;
import java.util.List;

@Service
public class UserService implements IUserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(CreateUserRequest createUserRequest) throws AuthException {
        if(!userRepository.existsByUsername(createUserRequest.getUsername())) {
            return userRepository.save(new User(createUserRequest.getUsername(), createUserRequest.getPassword()));
        }
        throw new AuthException();
    }

    //todo update

    @Override
    public boolean deleteUser(Long userId) {
         userRepository.deleteById(userId);
         return true;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }


}
