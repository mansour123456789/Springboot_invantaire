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

import com.example.model.ProduitActif;
import com.example.service.ProduitActifService;

@RestController
@RequestMapping("/api/produits-actifs")
public class ProduitActifController {
    
    @Autowired
    private ProduitActifService produitService;
    
    @PostMapping
    public ResponseEntity<ProduitActif> createProduit(
            @RequestBody ProduitActif produit,
            @RequestParam Long warehouseId) {
        ProduitActif created = produitService.createProduit(produit, warehouseId);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
    
    @GetMapping
    public List<ProduitActif> getAllProduits() {
        return produitService.getAllProduits();
    }
    
    @GetMapping("/{id}")
    public ProduitActif getProduitById(@PathVariable Long id) {
        return produitService.getProduitById(id);
    }
    
    @PutMapping("/{id}")
    public ProduitActif updateProduit(
            @PathVariable Long id, 
            @RequestBody ProduitActif produitDetails) {
        return produitService.updateProduit(id, produitDetails);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduit(@PathVariable Long id) {
        produitService.deleteProduit(id);
        return ResponseEntity.noContent().build();
    }
}