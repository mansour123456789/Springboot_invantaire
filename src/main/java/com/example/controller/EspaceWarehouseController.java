package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.EspaceWarehouse;
import com.example.service.EspaceWarehouseService;

@RestController
@RequestMapping("/api/espaces")
public class EspaceWarehouseController {
    
    @Autowired
    private EspaceWarehouseService espaceService;
    
    @PostMapping
    public ResponseEntity<EspaceWarehouse> createEspace(
            @RequestBody EspaceWarehouse espace,
            @RequestParam Long warehouseId) {
        EspaceWarehouse created = espaceService.createEspace(espace, warehouseId);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
    
    @GetMapping
    public List<EspaceWarehouse> getAllEspaces() {
        return espaceService.getAllEspaces();
    }
    
    @GetMapping("/{id}")
    public EspaceWarehouse getEspaceById(@PathVariable Long id) {
        return espaceService.getEspaceById(id);
    }
    
    @PutMapping("/{id}")
    public EspaceWarehouse updateEspace(
            @PathVariable Long id, 
            @RequestBody EspaceWarehouse espaceDetails) {
        return espaceService.updateEspace(id, espaceDetails);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEspace(@PathVariable Long id) {
        espaceService.deleteEspace(id);
        return ResponseEntity.noContent().build();
    }
}