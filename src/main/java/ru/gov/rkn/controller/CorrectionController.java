package ru.gov.rkn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gov.rkn.service.UnitedService;

import java.util.Map;

@Controller
public class CorrectionController {
    @Autowired
    private UnitedService unitedService;

    @GetMapping("/correct")
    public String getCorrectionPage(Map<String, Object> model) {
        model.put("channels", unitedService.getChannels());
        model.put("status", "no status");

        return "correction";
    }

    @PostMapping("/correct")
    public String getCorrectionPage(Map<String, Object> model,
                                    @RequestParam String channel,
                                    @RequestParam(required = false, defaultValue = "0") String frequency,
                                    @RequestParam(required = false, defaultValue = "0") String polarization) {
        String status = "Successfully saved!";
        try {
            double doubleFrequency = Double.valueOf(frequency);
            double doublePolarization = Double.valueOf(polarization);

            unitedService.updateChannel(channel, doubleFrequency, doublePolarization);
        } catch (NumberFormatException e) {
            status = "Invalid format";
        }


        model.put("channels", unitedService.getChannels());
        model.put("status", status);

        return "correction";
    }

}
