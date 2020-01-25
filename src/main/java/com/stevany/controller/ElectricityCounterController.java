package com.stevany.controller;

import com.stevany.model.ElectricityCounter;
import com.stevany.pojo.ConsumptionReport;
import com.stevany.service.ElectricityCounterService;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ElectricityCounterController {
    @Autowired
    private final ElectricityCounterService electricityCounterService;

    @PostMapping("/counter_callback")
    public ResponseEntity create(@Valid @RequestBody ElectricityCounter electricityCounter) {
        return ResponseEntity.ok(electricityCounterService.save(electricityCounter));
    }

    @GetMapping("/consumption_report")
    public ResponseEntity create(@RequestParam("duration") String duration) {
        Integer value = Integer.parseInt(duration.substring(0, 2));
        List<ConsumptionReport> consumptionReport = electricityCounterService.findAll(value);
        JSONObject item = new JSONObject();
        item.put("villages", consumptionReport);
        return ResponseEntity.ok(item);
    }
}
