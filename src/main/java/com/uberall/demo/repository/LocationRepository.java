package com.uberall.demo.repository;

import com.uberall.demo.model.Location;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location, Integer> {
}
