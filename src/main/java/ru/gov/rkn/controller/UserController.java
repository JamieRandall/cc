package ru.gov.rkn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gov.rkn.model.User;
import ru.gov.rkn.service.UserService;

import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public String getUsers(@RequestParam (required = false) String name, Map<String, Object> model) {
        Iterable<User> users = userService.getUsers(name);
        model.put("users", users);

        return "users";
    }

    @GetMapping("/usersave")
    public void saveUser() {
        userService.saveUser();
    }
}
