package ru.gov.rkn.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gov.rkn.model.enums.UserRole;
import ru.gov.rkn.security.details.UserDetailsImpl;

import java.util.Map;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getHello(Authentication authentication, ModelMap model) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        boolean isAdmin = userDetails.getUser().getRole().equals(UserRole.ADMIN);

        model.addAttribute("isAdmin", isAdmin);

        return "home";
    }

}
