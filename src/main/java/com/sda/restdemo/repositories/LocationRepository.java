package com.sda.restdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sda.restdemo.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

}
