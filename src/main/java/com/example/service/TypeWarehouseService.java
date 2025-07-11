package com.example.service;

import java.util.List;
import com.example.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.TypeWarehouseWarehousesDTO;
import com.example.model.TypeWarehouse;
import com.example.model.Warehouse;
import com.example.repository.TypeWarehouseRepository;
import com.example.dto.WarehouseDetailsDTO;
import com.example.dto.EspaceDTO;
import com.example.dto.ProduitWarehouseDTO;
import com.example.dto.TypeWarehouseDTO;
import com.example.dto.ProduitActifDTO;
import com.example.model.EspaceWarehouse;
import com.example.model.ProduitWarehouse;
import com.example.repository.EspaceWarehouseRepository;
import com.example.repository.ProduitWarehouseRepository;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class TypeWarehouseService {

    
    
    @Autowired
    private TypeWarehouseRepository typeWarehouseRepository;
    @Autowired
    private WarehouseRepository warehouseRepository;
    @Autowired
    private EspaceWarehouseRepository espaceWarehouseRepository;
    @Autowired
    private ProduitWarehouseRepository produitWarehouseRepository;

    TypeWarehouseService(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }
    
    public TypeWarehouseWarehousesDTO getWarehousesByTypeIdWithDetails1(int typeId) {
        TypeWarehouse type = typeWarehouseRepository.findById(typeId)
        		.orElseThrow(() -> new RuntimeException("User not found"));
        
        List<Warehouse> warehouses = warehouseRepository.findByType_Id(typeId);
        
        return new TypeWarehouseWarehousesDTO(type, warehouses);
    }
    
    public List<Warehouse> getWarehousesByTypeId(int typeId) {
        // Vérifier si le type existe
        typeWarehouseRepository.findById(typeId)
        .orElseThrow(() -> new RuntimeException("User not found"));
        
        return warehouseRepository.findByType_Id(typeId);
    }
    
    // Version avec DTO
    public TypeWarehouseWarehousesDTO getWarehousesByTypeIdWithDetails(int typeId) {
        TypeWarehouse type = typeWarehouseRepository.findById(typeId)
        		.orElseThrow(() -> new RuntimeException("User not found"));
        
        List<Warehouse> warehouses = warehouseRepository.findByType_Id(type.getId());
        
        return new TypeWarehouseWarehousesDTO(type, warehouses);
    }

    public TypeWarehouse createType(TypeWarehouse type) {
        return typeWarehouseRepository.save(type);
    }

    public List<TypeWarehouse> getAllTypes() {
        return typeWarehouseRepository.findAll();
    }

    public TypeWarehouse getTypeById(int id) {
        return typeWarehouseRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public TypeWarehouse updateType(int id, TypeWarehouse typeDetails) {
        TypeWarehouse type = getTypeById(id);
        type.setNomType(typeDetails.getNomType());
        return typeWarehouseRepository.save(type);
    }

    public void deleteType(int id) {
        typeWarehouseRepository.deleteById(id);
    }

    public WarehouseDetailsDTO getWarehouseDetailsById(Long id) {
        Warehouse warehouse = warehouseRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Warehouse not found"));

        List<EspaceWarehouse> espaces = espaceWarehouseRepository.findByWarehouseId(warehouse.getId());
        List<EspaceDTO> espaceDTOs = new ArrayList<>();
        for (EspaceWarehouse espace : espaces) {
            List<ProduitWarehouse> produits = produitWarehouseRepository.findByEspaceId(espace.getId());
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