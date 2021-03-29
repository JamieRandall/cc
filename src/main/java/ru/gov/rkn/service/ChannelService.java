package ru.gov.rkn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.gov.rkn.model.database.Channel;
import ru.gov.rkn.repository.ChannelRepository;

@Service
public class ChannelService {
    @Autowired
    private ChannelRepository channelRepository;

    public Iterable<Channel> findAll() {
        return channelRepository.findAll();
    }
}
