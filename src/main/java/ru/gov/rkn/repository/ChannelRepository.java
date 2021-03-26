package ru.gov.rkn.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gov.rkn.model.Channel;

@Repository
public interface ChannelRepository extends CrudRepository<Channel, Integer> {
//    Page<Channel> findAllBy
}
