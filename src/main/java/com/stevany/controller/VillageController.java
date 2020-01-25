package com.stevany.controller;

import com.stevany.model.Village;
import com.stevany.service.VillageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class VillageController {
    @Autowired
    private final VillageService villageService;

    @GetMapping("/counter")
    public ResponseEntity<Village> findById(@RequestParam("id") Long id) {
        Optional<Village> stock = villageService.findById(id);
        if (!stock.isPresent()) {
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(stock.get());
    }
}
