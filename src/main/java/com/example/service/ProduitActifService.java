package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.ProduitActif;
import com.example.model.Warehouse;
import com.example.repository.ProduitActifRepository;
import com.example.repository.WarehouseRepository;

@Service
public class ProduitActifService {
    
    @Autowired
    private ProduitActifRepository produitRepository;
    
    @Autowired
    private WarehouseRepository warehouseRepository;

    public ProduitActif createProduit(ProduitActif produit, Long warehouseId) {
        Warehouse warehouse = warehouseRepository.findById(warehouseId).orElseThrow(() -> new RuntimeException("User not found"));
        produit.setWarehouse(warehouse);
        return produitRepository.save(produit);
    }

    public List<ProduitActif> getAllProduits() {
        return produitRepository.findAll();
    }

    public ProduitActif getProduitById(Long id) {
        return produitRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public ProduitActif updateProduit(Long id, ProduitActif produitDetails) {
        ProduitActif produit = getProduitById(id);
        produit.setNomProduit(produitDetails.getNomProduit());
        produit.setRfidTag(produitDetails.getRfidTag());
        produit.setTag(produitDetails.getTag());
        return produitRepository.save(produit);
    }

    public void deleteProduit(Long id) {
        produitRepository.deleteById(id);
    }
}