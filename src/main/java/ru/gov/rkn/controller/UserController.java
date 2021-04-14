package ru.gov.rkn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;
import ru.gov.rkn.model.database.User;
import ru.gov.rkn.model.enums.UserRole;
import ru.gov.rkn.model.form.UserForm;
import ru.gov.rkn.service.UserService;

import java.util.Arrays;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String getUsers(ModelMap model) {
        Iterable<User> users = userService.getUsers();
        model.addAttribute("users", users);
        model.addAttribute("roles", UserRole.getRoles());

        return "users";
    }

    @PostMapping("/users/create")
    public String saveUser(UserForm userForm) {
        userService.saveUser(userForm);

        return "redirect:/users";
    }

    @DeleteMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable String id) {
        userService.delete(Integer.valueOf(id));

        return "redirect:/users";
    }
}
