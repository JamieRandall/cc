package ru.gov.rkn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gov.rkn.model.Channel;
import ru.gov.rkn.model.User;
import ru.gov.rkn.repository.ChannelRepository;
import ru.gov.rkn.repository.UserRepository;

import java.util.List;

@Service
public class UnitedService {
    @Autowired
    private ChannelRepository channelRepository;
    @Autowired
    private UserRepository userRepository;

    public Iterable<Channel> getChannels() {
        return channelRepository.findAll();
    }

    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }
}
