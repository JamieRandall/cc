package ru.gov.rkn.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gov.rkn.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
