package com.stevany.service.impl;

import com.stevany.model.Village;
import com.stevany.repository.VillageRepository;
import com.stevany.service.VillageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class VillageServiceImpl implements VillageService {
    @Autowired
    private VillageRepository villageRepository;

    @Override
    public Village save(Village village) {
        return villageRepository.save(village);
    }

    @Override
    public Optional<Village> findById(Long id) {
        return villageRepository.findById(id);
    }
}
