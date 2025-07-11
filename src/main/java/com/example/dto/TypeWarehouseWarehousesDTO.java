package com.example.dto;

import java.util.List;

import com.example.model.TypeWarehouse;
import com.example.model.Warehouse;

public class TypeWarehouseWarehousesDTO {
    private TypeWarehouse type;
    private List<Warehouse> warehouses;
    
    public TypeWarehouseWarehousesDTO(TypeWarehouse type, List<Warehouse> warehouses) {
        this.type = type;
        this.warehouses = warehouses;
    }
    
    // Getters
    public TypeWarehouse getType() { return type; }
    public List<Warehouse> getWarehouses() { return warehouses; }
}