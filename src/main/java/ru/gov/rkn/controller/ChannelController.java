package ru.gov.rkn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.gov.rkn.model.database.Channel;
import ru.gov.rkn.model.enums.ChannelCountry;
import ru.gov.rkn.model.enums.ChannelEncoding;
import ru.gov.rkn.model.enums.ChannelPolarization;
import ru.gov.rkn.model.enums.ChannelType;
import ru.gov.rkn.service.ChannelService;

import java.util.Arrays;
import java.util.Map;

@Controller
public class ChannelController {
    @Autowired
    private ChannelService channelService;

    @GetMapping("/channels")
    public String showChannelSelect(ModelMap model) {
        Iterable<Channel> channels = channelService.findAll();
        model.addAttribute("channels", channels);

        return "channels";
    }

    @PostMapping("/channels")
    public String showChannelInfo(ModelMap model, String channelName) {
        Channel channel = channelService.findChannel(channelName);
        Iterable<Channel> channels = channelService.findAll();

        model.addAttribute("channels", channels);
        model.addAttribute("channel", channel);
        model.addAttribute("types", Arrays.asList(ChannelType.values()));
        model.addAttribute("polarizations", Arrays.asList(ChannelPolarization.values()));
        model.addAttribute("countries", Arrays.asList(ChannelCountry.values()));
        model.addAttribute("encodings", Arrays.asList(ChannelEncoding.values()));

        return "channels";
    }

    @GetMapping("/channels/change")
    public String showChannelChangePage(Map<String, Object> model) {
        Iterable<Channel> channels = channelService.findAll();
        model.put("channels", channels);

        return "channelChange";
    }
}
