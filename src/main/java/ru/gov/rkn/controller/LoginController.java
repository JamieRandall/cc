package ru.gov.rkn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String getLoginPage(HttpServletRequest request,
                               ModelMap model,
                               @RequestParam (required =  false) String error) {
        if (request.getParameterMap().containsKey("error")) {
            model.addAttribute("error", true);
        }
        return "login";
    }

//    @PostMapping("/login")
//    public String logIn
}
