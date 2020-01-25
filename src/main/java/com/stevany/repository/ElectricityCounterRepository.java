package com.stevany.repository;

import com.stevany.model.ElectricityCounter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("electricityCounterRepository")
public interface ElectricityCounterRepository extends JpaRepository<ElectricityCounter, Long> {
    @Query("SELECT c FROM ElectricityCounter c WHERE TIMESTAMPDIFF(hour, c.updatedAt, curdate()) < :value")
    List<ElectricityCounter> findAll(@Param("value") Integer value);
}
