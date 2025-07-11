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

import com.example.model.ProduitWarehouse;
import com.example.service.ProduitWarehouseService;

@RestController
@RequestMapping("/api/produits-warehouse")
public class ProduitWarehouseController {
    
    @Autowired
    private ProduitWarehouseService produitService;
    
    @PostMapping
    public ResponseEntity<ProduitWarehouse> createProduit(
            @RequestBody ProduitWarehouse produit,
            @RequestParam Long espaceId) {
        ProduitWarehouse created = produitService.createProduit(produit, espaceId);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
    
    @GetMapping
    public List<ProduitWarehouse> getAllProduits() {
        return produitService.getAllProduits();
    }
    
    @GetMapping("/{id}")
    public ProduitWarehouse getProduitById(@PathVariable Long id) {
        return produitService.getProduitById(id);
    }
    
    @PutMapping("/{id}")
    public ProduitWarehouse updateProduit(
            @PathVariable Long id, 
            @RequestBody ProduitWarehouse produitDetails) {
        return produitService.updateProduit(id, produitDetails);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduit(@PathVariable Long id) {
        produitService.deleteProduit(id);
        return ResponseEntity.noContent().build();
    }
}