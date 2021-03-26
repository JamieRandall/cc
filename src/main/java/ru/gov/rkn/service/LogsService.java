package ru.gov.rkn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gov.rkn.repository.ChannelRepository;

@Service
public class LogsService {
    @Autowired
    private ChannelRepository channelRepository;


}
