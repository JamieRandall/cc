package ru.gov.rkn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.gov.rkn.model.Channel;
import ru.gov.rkn.service.UnitedService;

import java.util.Map;

@Controller
public class ChangeController {
    @Autowired
    private UnitedService unitedService;

    @GetMapping("/change")
    public String getChangePage(Map<String, Object> model) {
        Iterable<Channel> channels = unitedService.getChannels();

        model.put("channels", channels);

        return "changePage";
    }
}
