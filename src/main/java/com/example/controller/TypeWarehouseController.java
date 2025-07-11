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
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.TypeWarehouseWarehousesDTO;
import com.example.model.TypeWarehouse;
import com.example.model.Warehouse;
import com.example.service.TypeWarehouseService;
import com.example.dto.WarehouseDetailsDTO;
import com.example.repository.EspaceWarehouseRepository;
import com.example.repository.ProduitWarehouseRepository;
import com.example.dto.EspaceDTO;
import com.example.dto.ProduitWarehouseDTO;
import com.example.dto.TypeWarehouseDTO;
import com.example.dto.ProduitActifDTO;

@RestController
@RequestMapping("/api/types")
public class TypeWarehouseController {
    
    @Autowired
    private TypeWarehouseService typeService;
    
    @Autowired
    private EspaceWarehouseRepository espaceWarehouseRepository;

    @Autowired
    private ProduitWarehouseRepository produitWarehouseRepository;
    
    

    @GetMapping("/warehouses/{id}")
    public WarehouseDetailsDTO getWarehouseById(@PathVariable Long id) {
        return typeService.getWarehouseDetailsById(id);
    }
    
    
    
    
    @GetMapping("/{typeId}/warehouses-details")
    public ResponseEntity<TypeWarehouseWarehousesDTO> getWarehousesByTypeWithDetails(
            @PathVariable int typeId) {
        TypeWarehouseWarehousesDTO dto = typeService.getWarehousesByTypeIdWithDetails(typeId);
        return ResponseEntity.ok(dto);
    }
    // Version simple
    @GetMapping("/{typeId}/warehouses")
    public ResponseEntity<List<Warehouse>> getWarehousesByType(@PathVariable int typeId) {
        List<Warehouse> warehouses = typeService.getWarehousesByTypeId(typeId);
        return ResponseEntity.ok(warehouses);
    }
    
    
    @PostMapping
    public ResponseEntity<TypeWarehouse> createType(@RequestBody TypeWarehouse type) {
        TypeWarehouse created = typeService.createType(type);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
    
    @GetMapping
    public List<TypeWarehouse> getAllTypes() {
        return typeService.getAllTypes();
    }
    
    @GetMapping("/{id}")
    public TypeWarehouse getTypeById(@PathVariable  int id) {
        return typeService.getTypeById(id);
    }

    @PutMapping("/{id}")
    public TypeWarehouse updateType(
            @PathVariable int id, 
            @RequestBody TypeWarehouse typeDetails) {
        return typeService.updateType(id, typeDetails);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteType(@PathVariable int id) {
        typeService.deleteType(id);
        return ResponseEntity.noContent().build();
    }
}