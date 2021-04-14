package ru.gov.rkn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.gov.rkn.model.database.User;
import ru.gov.rkn.model.enums.UserRole;
import ru.gov.rkn.model.form.UserForm;
import ru.gov.rkn.repository.UserRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    public void saveUser(UserForm userForm) {
        userForm.setPassword(passwordEncoder.encode(userForm.getPassword()));
        User user = User.fromForm(userForm);

        userRepository.save(user);
    }

    public void delete(Integer id) {
        Optional<User> userCandidate = userRepository.findById(id);
        if (userCandidate.isPresent()) {
            userRepository.delete(userCandidate.get());
        }
    }
}
