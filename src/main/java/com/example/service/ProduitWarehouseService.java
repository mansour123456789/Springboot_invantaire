package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.EspaceWarehouse;
import com.example.model.ProduitWarehouse;
import com.example.repository.EspaceWarehouseRepository;
import com.example.repository.ProduitWarehouseRepository;

@Service
public class ProduitWarehouseService {
    
    @Autowired
    private ProduitWarehouseRepository produitRepository;
    
    @Autowired
    private EspaceWarehouseRepository espaceRepository;

    public ProduitWarehouse createProduit(ProduitWarehouse produit, Long espaceId) {
        EspaceWarehouse espace = espaceRepository.findById(espaceId).orElseThrow(() -> new RuntimeException("User not found"));
        produit.setEspace(espace);
        return produitRepository.save(produit);
    }

    public List<ProduitWarehouse> getAllProduits() {
        return produitRepository.findAll();
    }

    public ProduitWarehouse getProduitById(Long id) {
        return produitRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public ProduitWarehouse updateProduit(Long id, ProduitWarehouse produitDetails) {
        ProduitWarehouse produit = getProduitById(id);
        produit.setNomProduit(produitDetails.getNomProduit());
        produit.setRfidTag(produitDetails.getRfidTag());
        produit.setTag(produitDetails.getTag());
        return produitRepository.save(produit);
    }

    public void deleteProduit(Long id) {
        produitRepository.deleteById(id);
    }
}