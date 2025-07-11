package com.example.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.EspaceDTO;
import com.example.dto.ProduitActifDTO;
import com.example.dto.ProduitWarehouseDTO;
import com.example.dto.TypeWarehouseDTO;
import com.example.dto.WarehouseDetailsDTO;
import com.example.model.EspaceWarehouse;
import com.example.model.ProduitActif;
import com.example.model.ProduitWarehouse;
import com.example.model.TypeWarehouse;
import com.example.model.Warehouse;
import com.example.repository.EspaceWarehouseRepository;
import com.example.repository.ProduitActifRepository;
import com.example.repository.ProduitWarehouseRepository;
import com.example.repository.TypeWarehouseRepository;
import com.example.repository.WarehouseRepository;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class WarehouseService {
    
    @Autowired
    private WarehouseRepository warehouseRepository;
    
    @Autowired
    private TypeWarehouseRepository typeWarehouseRepository;
    
    
    
    
    
    
    
    
    
    
    
    
    
    @Autowired
    private EspaceWarehouseRepository espaceRepository;
    
    @Autowired
    private ProduitWarehouseRepository produitWarehouseRepository;
    
    @Autowired
    private ProduitActifRepository produitActifRepository;

   
    private Map<Integer, TypeWarehouse> loadTypesForWarehouses(List<Warehouse> warehouses) {
        List<Integer> typeIds = warehouses.stream().filter(w -> w.getType() != null)
        		.map(w -> w.getType().getId())
            .distinct()
            .collect(Collectors.toList());
        
        return typeWarehouseRepository.findAllById(typeIds)
            .stream()
            .collect(Collectors.toMap(TypeWarehouse::getId, Function.identity()));
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    public Warehouse createWarehouse(Warehouse warehouse, int typeId) {
        TypeWarehouse type = typeWarehouseRepository.findById(typeId).orElseThrow(() -> new RuntimeException("User not found"));

        warehouse.setType( type);
        return warehouseRepository.save(warehouse);
    }

    public List<Warehouse> getAllWarehouses() {
        return warehouseRepository.findAll();
    }

    public Warehouse getWarehouseById(Long id) {
        return warehouseRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public Warehouse updateWarehouse(Long id, Warehouse warehouseDetails) {
        Warehouse warehouse = getWarehouseById(id);
        warehouse.setNom(warehouseDetails.getNom());
        warehouse.setAdresse(warehouseDetails.getAdresse());
        warehouse.setEmail(warehouseDetails.getEmail());
        warehouse.setNomResponsable(warehouseDetails.getNomResponsable());
        warehouse.setMailResp(warehouseDetails.getMailResp());
        warehouse.setTelResp(warehouseDetails.getTelResp());
        return warehouseRepository.save(warehouse);
    }

    public void deleteWarehouse(Long id) {
        warehouseRepository.deleteById(id);
    }

    public WarehouseDetailsDTO getWarehouseDetailsById(Long id) {
        Warehouse warehouse = warehouseRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Warehouse not found"));

        List<EspaceWarehouse> espaces = espaceRepository.findByWarehouse_Id(warehouse.getId());
        List<EspaceDTO> espaceDTOs = new ArrayList<>();
        for (EspaceWarehouse espace : espaces) {
            List<ProduitWarehouse> produits = produitWarehouseRepository.findByEspace_Id(espace.getId());
            List<ProduitWarehouseDTO> produitDTOs = produits.stream()
                .map(ProduitWarehouseDTO::new)
                .collect(Collectors.toList());
            espaceDTOs.add(new EspaceDTO(espace, produitDTOs));
        }
        TypeWarehouseDTO typeDTO = new TypeWarehouseDTO(warehouse.getType());
        List<ProduitActifDTO> produitsActifs = new ArrayList<>(); // à adapter si besoin

        return new WarehouseDetailsDTO(warehouse, typeDTO, espaceDTOs, produitsActifs);
    }
}