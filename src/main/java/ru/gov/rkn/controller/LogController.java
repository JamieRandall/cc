package ru.gov.rkn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gov.rkn.model.Channel;
import ru.gov.rkn.model.User;
import ru.gov.rkn.service.LogsService;
import ru.gov.rkn.service.UnitedService;

import java.util.Map;

@Controller
public class LogController {
    @Autowired
    private UnitedService unitedService;
    @Autowired
    private LogsService logsService;

    @GetMapping("/logs")
    public String getLogs(Map<String, Object> model) {
        Iterable<Channel> channels = unitedService.getChannels();
        Iterable<User> users = unitedService.getUsers();
        model.put("channels", channels);
        model.put("users", users);

        return "logs";
    }

    @PostMapping("/logs")
    public String getLogs(Map<String, Object> model,
                          @RequestParam String channel,
                          @RequestParam String user,
                          @RequestParam String sortBy) {

//        Iterable<Channel> channels = logsService.findChannels()

//        Iterable<Channel> channels = unitedService.getChannels();
//        Iterable<User> users = unitedService.getUsers();
//        model.put("channels", channels);
//        model.put("users", users);

        return "logs";
    }
}
