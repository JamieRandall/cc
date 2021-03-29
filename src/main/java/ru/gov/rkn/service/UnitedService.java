package ru.gov.rkn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gov.rkn.model.database.Channel;
import ru.gov.rkn.model.database.User;
import ru.gov.rkn.model.database.Log;
import ru.gov.rkn.repository.ChannelRepository;
import ru.gov.rkn.repository.LogRepository;
import ru.gov.rkn.repository.UserRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class UnitedService {
    @Autowired
    private ChannelRepository channelRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LogRepository logRepository;

    public Iterable<Channel> getChannels() {
        Sort sortById = Sort.by(Sort.Direction.ASC, "name");
        return channelRepository.findAll(sortById);
    }

    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public void updateChannel(String name, double doubleFrequency, double doublePolarization) {
        Channel channel = channelRepository.findChannelByName(name).get();
        User user = userRepository.findById(1).get();
        String stringTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy"));

        Log log = Log.builder()
                .newFrequency(doubleFrequency)
                .newPolarizationValue(doublePolarization)
                .cc_user(user)
                .created(stringTime)
                .channel(channel)
                .build();

        logRepository.save(log);

//        if (doubleFrequency != 0d) {
//            channel.setFrequency(doubleFrequency);
//        }
//        if (doublePolarization != 0d) {
//            channel.setPolarizaionValue(doublePolarization);
//        }
    }
}
