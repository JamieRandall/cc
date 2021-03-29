package ru.gov.rkn.repository;

import org.springframework.data.repository.CrudRepository;
import ru.gov.rkn.model.database.Log;

public interface LogRepository extends CrudRepository<Log, Integer> {
}
