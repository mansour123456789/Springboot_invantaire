package com.example.dto;

import com.example.model.ProduitActif;

//ProduitActifDTO.java
public class ProduitActifDTO {
 private Long id;
 private String nomProduit;
 private String rfidTag;
 private String tag;
 
 public ProduitActifDTO(ProduitActif produit) {
     this.id = produit.getId();
     this.nomProduit = produit.getNomProduit();
     this.rfidTag = produit.getRfidTag();
     this.tag = produit.getTag();
 }
}