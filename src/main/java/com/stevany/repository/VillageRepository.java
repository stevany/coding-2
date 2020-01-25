package com.stevany.repository;

import com.stevany.model.Village;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("villageRepository")
public interface VillageRepository extends JpaRepository<Village, Long> {
}
