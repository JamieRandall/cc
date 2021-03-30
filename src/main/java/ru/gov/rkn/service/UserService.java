package ru.gov.rkn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gov.rkn.model.database.User;
import ru.gov.rkn.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    public void saveUser(String name, String pswd) {
        User user = User.builder()
                .username(name)
                .password(pswd)
                .build();

        userRepository.save(user);
    }
}
