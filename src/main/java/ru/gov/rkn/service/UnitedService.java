package ru.gov.rkn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gov.rkn.model.Channel;
import ru.gov.rkn.model.User;
import ru.gov.rkn.repository.ChannelRepository;
import ru.gov.rkn.repository.UserRepository;

import java.util.Arrays;
import java.util.List;

@Service
public class UnitedService {
    @Autowired
    private ChannelRepository channelRepository;
    @Autowired
    private UserRepository userRepository;

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

        if (doubleFrequency != 0d) {
            channel.setFrequency(doubleFrequency);
        }
        if (doublePolarization != 0d) {
            channel.setPolarizaionValue(doublePolarization);
        }
    }
}
