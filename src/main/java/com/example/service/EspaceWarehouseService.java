package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.EspaceWarehouse;
import com.example.model.Warehouse;
import com.example.repository.EspaceWarehouseRepository;
import com.example.repository.WarehouseRepository;

@Service
public class EspaceWarehouseService {
    
    @Autowired
    private EspaceWarehouseRepository espaceRepository;
    
    @Autowired
    private WarehouseRepository warehouseRepository;

    public EspaceWarehouse createEspace(EspaceWarehouse espace, long id) {
        Warehouse warehouse = warehouseRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
            
        espace.setWarehouse(warehouse);
        return espaceRepository.save(espace);
    }

    public List<EspaceWarehouse> getAllEspaces() {
        return espaceRepository.findAll();
    }

    public EspaceWarehouse getEspaceById(Long id) {
        return espaceRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
            
    }

    public EspaceWarehouse updateEspace(Long id, EspaceWarehouse espaceDetails) {
       EspaceWarehouse espace = espaceRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        espace.setIdTag(espaceDetails.getIdTag());
        espace.setNomResponsable(espaceDetails.getNomResponsable());
        espace.setMailResp(espaceDetails.getMailResp());
        espace.setTelResp(espaceDetails.getTelResp());
        return espaceRepository.save(espace);
    }

    public void deleteEspace(Long id) {
        espaceRepository.deleteById(id);
    }
}