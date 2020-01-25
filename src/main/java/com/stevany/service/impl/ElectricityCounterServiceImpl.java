package com.stevany.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stevany.model.ElectricityCounter;
import com.stevany.pojo.ConsumptionReport;
import com.stevany.pojo.Village;
import com.stevany.repository.ElectricityCounterRepository;
import com.stevany.service.ElectricityCounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class ElectricityCounterServiceImpl implements ElectricityCounterService {
    private final ElectricityCounterRepository electricityCounterRepository;

    @Autowired
    private RestTemplate restTemplate;

    public ElectricityCounterServiceImpl(@Autowired @Qualifier("electricityCounterRepository") ElectricityCounterRepository electricityCounterRepository) {
        this.electricityCounterRepository = electricityCounterRepository;
    }


    @Override
    public ElectricityCounter save(ElectricityCounter electricityCounter) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        String restResult = restTemplate.exchange("http://localhost:8080/api/counter?id=" + electricityCounter.getCounterId(), HttpMethod.GET, entity, String.class).getBody();
        ObjectMapper mapper = new ObjectMapper();
        Village value = null;
        try {
            value = mapper.readValue(restResult , Village.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        electricityCounter.setVillageName(value.getName());
        return electricityCounterRepository.save(electricityCounter);
    }

    @Override
    public List<ConsumptionReport> findAll(Integer value) {
        List<ElectricityCounter> electricityCounterList=  electricityCounterRepository.findAll(value);
        List<ConsumptionReport> consumptionReportList = new ArrayList<>();
        for(int i = 0; i< electricityCounterList.size(); i++){
            ConsumptionReport consumptionReport = new ConsumptionReport();
            consumptionReport.setVillageName(electricityCounterList.get(i).getVillageName());
            consumptionReport.setConsumptionTime(electricityCounterList.get(i).getAmount());
            consumptionReportList.add(consumptionReport);
        }
        return consumptionReportList;
    }
}
