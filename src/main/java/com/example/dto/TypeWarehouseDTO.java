package com.example.dto;

import com.example.model.TypeWarehouse;

public class TypeWarehouseDTO {
    private int id;
    private String nomType;

    public TypeWarehouseDTO() {}

    public TypeWarehouseDTO(TypeWarehouse type) {
        this.id = type.getId();
        this.nomType = type.getNomType();
    }

    public int getId() { return id; }
    public String getNomType() { return nomType; }
}