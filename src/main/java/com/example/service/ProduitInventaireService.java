package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Inventaire;
import com.example.model.ProduitInventaire;
import com.example.repository.InventaireRepository;
import com.example.repository.ProduitInventaireRepository;

@Service
public class ProduitInventaireService {
    
    @Autowired
    private ProduitInventaireRepository produitRepository;
    
    @Autowired
    private InventaireRepository inventaireRepository;

    public ProduitInventaire createProduit(ProduitInventaire produit, Long inventaireId) {
        Inventaire inventaire = inventaireRepository.findById(inventaireId).orElseThrow(() -> new RuntimeException("User not found"));
        produit.setInventaire(inventaire);
        return produitRepository.save(produit);
    }

    public List<ProduitInventaire> getAllProduits() {
        return produitRepository.findAll();
    }

    public ProduitInventaire getProduitById(Long id) {
        return produitRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public ProduitInventaire updateProduit(Long id, ProduitInventaire produitDetails) {
        ProduitInventaire produit = getProduitById(id);
        produit.setNomProduit(produitDetails.getNomProduit());
        produit.setRfidTag(produitDetails.getRfidTag());
        return produitRepository.save(produit);
    }

    public void deleteProduit(Long id) {
        produitRepository.deleteById(id);
    }
}