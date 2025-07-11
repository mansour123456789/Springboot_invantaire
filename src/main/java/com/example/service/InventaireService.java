package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.EspaceWarehouse;
import com.example.model.Inventaire;
import com.example.model.User;
import com.example.repository.EspaceWarehouseRepository;
import com.example.repository.InventaireRepository;
import com.example.repository.UserRepository;

@Service
public class InventaireService {
    
    @Autowired
    private InventaireRepository inventaireRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private EspaceWarehouseRepository espaceRepository;

    public Inventaire createInventaire(Inventaire inventaire, List<Long> userIds, List<Long> espaceIds) {
        List<User> users = userRepository.findAllById(userIds);
        List<EspaceWarehouse> espaces = espaceRepository.findAllById(espaceIds);
        
        inventaire.setUtilisateurs(users);
        inventaire.setEspaces(espaces);
        
        return inventaireRepository.save(inventaire);
    }

    public List<Inventaire> getAllInventaires() {
        return inventaireRepository.findAll();
    }

    public Inventaire getInventaireById(Long id) {
        return inventaireRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
            
    }

    public Inventaire updateInventaire(Long id, Inventaire inventaireDetails) {
        Inventaire inventaire = getInventaireById(id);
        inventaire.setDate(inventaireDetails.getDate());
        inventaire.setNom(inventaireDetails.getNom());
        inventaire.setNbInventaire(inventaireDetails.getNbInventaire());
        inventaire.setDescription(inventaireDetails.getDescription());
        return inventaireRepository.save(inventaire);
    }

    public void deleteInventaire(Long id) {
        inventaireRepository.deleteById(id);
    }
}