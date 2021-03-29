package ru.gov.rkn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gov.rkn.model.database.Log;
import ru.gov.rkn.repository.ChannelRepository;
import ru.gov.rkn.repository.LogRepository;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class LogsService {
    @Autowired
    private LogRepository logRepository;

    public Set<Log> getLogs() {
        Set<Log> logs = new TreeSet<>();
        logRepository.findAll().forEach(logs::add);

        return logs;
    }


    public Set<Log> findLogsByChannelAndUser(String channelName, String userName) {
        Set<Log> logs = new TreeSet<>();
        List<Log> fromDB = new ArrayList<>();
        logRepository.findAll().forEach(fromDB::add);
        fromDB.stream()
                .filter(l -> {
                    return l.getChannel().getName().equals(channelName) && l.getCc_user().getName().equals(userName) ? true : false;
                })
                .forEach(logs::add);

        return logs;
    }
}
