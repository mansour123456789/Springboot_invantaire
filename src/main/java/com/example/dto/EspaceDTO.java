package com.example.dto;

import java.util.List;

import com.example.model.EspaceWarehouse;

//EspaceDTO.java
public class EspaceDTO {
 private Long id;
 private String idTag;
 private String nomResponsable;
 private String mailResp;
 private String telResp;
 private List<ProduitWarehouseDTO> produits;
 
 public EspaceDTO() {}

 public EspaceDTO(EspaceWarehouse espace, List<ProduitWarehouseDTO> produits) {
     this.id = espace.getId();
     this.idTag = espace.getIdTag();
     this.nomResponsable = espace.getNomResponsable();
     this.mailResp = espace.getMailResp();
     this.telResp = espace.getTelResp();
     this.produits = produits;
 }

 public Long getId() { return id; }
 public String getIdTag() { return idTag; }
 public String getNomResponsable() { return nomResponsable; }
 public String getMailResp() { return mailResp; }
 public String getTelResp() { return telResp; }
 public List<ProduitWarehouseDTO> getProduits() { return produits; }
}