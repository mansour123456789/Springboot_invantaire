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

import com.example.model.Inventaire;
import com.example.service.InventaireService;

@RestController
@RequestMapping("/api/inventaires")
public class InventaireController {
    
    @Autowired
    private InventaireService inventaireService;
    
    @PostMapping
    public ResponseEntity<Inventaire> createInventaire(
            @RequestBody Inventaire inventaire,
            @RequestParam List<Long> userIds,
            @RequestParam List<Long> espaceIds) {
        Inventaire created = inventaireService.createInventaire(inventaire, userIds, espaceIds);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
    
    @GetMapping
    public List<Inventaire> getAllInventaires() {
        return inventaireService.getAllInventaires();
    }
    
    @GetMapping("/{id}")
    public Inventaire getInventaireById(@PathVariable Long id) {
        return inventaireService.getInventaireById(id);
    }
    
    @PutMapping("/{id}")
    public Inventaire updateInventaire(
            @PathVariable Long id, 
            @RequestBody Inventaire inventaireDetails) {
        return inventaireService.updateInventaire(id, inventaireDetails);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInventaire(@PathVariable Long id) {
        inventaireService.deleteInventaire(id);
        return ResponseEntity.noContent().build();
    }
}