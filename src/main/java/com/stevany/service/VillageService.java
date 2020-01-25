package com.stevany.service;

import com.stevany.model.Village;

import java.util.Optional;

public interface VillageService {
    Village save(Village village);
    Optional<Village>findById(Long id);

}
