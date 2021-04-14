package ru.gov.rkn.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gov.rkn.model.database.Channel;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChannelRepository extends CrudRepository<Channel, Integer> {
    Optional<Channel> findChannelByName(String name);

    List<Channel> findAll(Sort sort);
}
