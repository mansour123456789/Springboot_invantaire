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

import com.example.dto.WarehouseDetailsDTO;
import com.example.model.Warehouse;
import com.example.service.WarehouseService;

@RestController
@RequestMapping("/api/warehouses")
public class WarehouseController {
    
    @Autowired
    private WarehouseService warehouseService;
    
    
    
    
    
 
    @PostMapping
    public ResponseEntity<Warehouse> createWarehouse(
            @RequestBody Warehouse warehouse,
            @RequestParam int typeId) {
        Warehouse created = warehouseService.createWarehouse(warehouse, typeId);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
    
    @GetMapping
    public List<Warehouse> getAllWarehouses() {
        return warehouseService.getAllWarehouses();
    }
    
    @GetMapping("/{id}")
    public WarehouseDetailsDTO getWarehouseById(@PathVariable Long id) {
        return warehouseService.getWarehouseDetailsById(id);
    }
    
    @PutMapping("/{id}")
    public Warehouse updateWarehouse(
            @PathVariable Long id, 
            @RequestBody Warehouse warehouseDetails) {
        return warehouseService.updateWarehouse(id, warehouseDetails);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWarehouse(@PathVariable Long id) {
        warehouseService.deleteWarehouse(id);
        return ResponseEntity.noContent().build();
    }
}