package com.example.dto;

import com.example.model.ProduitWarehouse;

public class ProduitWarehouseDTO {
    private Long id;
    private String nomProduit;
    private String rfidTag;
    private String tag;

    public ProduitWarehouseDTO() {}

    public ProduitWarehouseDTO(ProduitWarehouse produit) {
        this.id = produit.getId();
        this.nomProduit = produit.getNomProduit();
        this.rfidTag = produit.getRfidTag();
        this.tag = produit.getTag();
    }

    public Long getId() { return id; }
    public String getNomProduit() { return nomProduit; }
    public String getRfidTag() { return rfidTag; }
    public String getTag() { return tag; }
}