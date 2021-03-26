package ru.gov.rkn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gov.rkn.model.User;
import ru.gov.rkn.repository.UserRepository;

import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Iterable<User> getUsers(String name) {
        return userRepository.findAll();
    }

    public void saveUser() {
        User user = new User();
        user.setName("Jack");
        user.setPassword("1");
        userRepository.save(user);
    }
}
