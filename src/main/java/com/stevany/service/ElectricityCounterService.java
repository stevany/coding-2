package com.stevany.service;

import com.stevany.model.ElectricityCounter;
import com.stevany.pojo.ConsumptionReport;

import java.util.List;

public interface ElectricityCounterService {
    ElectricityCounter save(ElectricityCounter electricityCounter);
    List<ConsumptionReport> findAll(Integer value);
}
