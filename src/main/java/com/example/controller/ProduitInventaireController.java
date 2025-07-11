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

import com.example.model.ProduitInventaire;
import com.example.service.ProduitInventaireService;

@RestController
@RequestMapping("/api/produits-inventaire")
public class ProduitInventaireController {
    
    @Autowired
    private ProduitInventaireService produitService;
    
    @PostMapping
    public ResponseEntity<ProduitInventaire> createProduit(
            @RequestBody ProduitInventaire produit,
            @RequestParam Long inventaireId) {
        ProduitInventaire created = produitService.createProduit(produit, inventaireId);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
    
    @GetMapping
    public List<ProduitInventaire> getAllProduits() {
        return produitService.getAllProduits();
    }
    
    @GetMapping("/{id}")
    public ProduitInventaire getProduitById(@PathVariable Long id) {
        return produitService.getProduitById(id);
    }
    
    @PutMapping("/{id}")
    public ProduitInventaire updateProduit(
            @PathVariable Long id, 
            @RequestBody ProduitInventaire produitDetails) {
        return produitService.updateProduit(id, produitDetails);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduit(@PathVariable Long id) {
        produitService.deleteProduit(id);
        return ResponseEntity.noContent().build();
    }
}