package ru.gov.rkn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gov.rkn.model.database.Channel;
import ru.gov.rkn.service.ChannelService;

import java.util.Map;

@Controller
public class ChannelController {
    @Autowired
    private ChannelService channelService;

    @GetMapping("/channels")
    public String showChannelTablePage(Map<String, Object> model) {
        Iterable<Channel> channels = channelService.findAll();
        model.put("channels", channels);

        return "channels";
    }

    @GetMapping("/channels/change")
    public String showChannelChangePage(Map<String, Object> model) {
        Iterable<Channel> channels = channelService.findAll();
        model.put("channels", channels);

        return "channelChange";
    }
}
