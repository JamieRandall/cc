package ru.gov.rkn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gov.rkn.model.database.User;
import ru.gov.rkn.service.UserService;

import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String getUsers(Map<String, Object> model) {
        Iterable<User> users = userService.getUsers();
        model.put("users", users);

        return "users";
    }

    @PostMapping("/users")
    public String saveUser(Map<String, Object> model,
                           @RequestParam String name,
                           @RequestParam String pswd) {
        userService.saveUser(name, pswd);
        Iterable<User> users = userService.getUsers();
        model.put("users", users);

        return "users";
    }
}
