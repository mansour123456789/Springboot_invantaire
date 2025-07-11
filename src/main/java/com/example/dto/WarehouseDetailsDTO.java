package com.example.dto;

import java.util.List;

import com.example.model.Warehouse;

public class WarehouseDetailsDTO {
 private Long id;
 private String nom;
 private String adresse;
 private String email;
 private String nomResponsable;
 private String mailResp;
 private String telResp;
 private TypeWarehouseDTO type;
 private List<EspaceDTO> espaceWarehouses; // <-- renommé
 private List<ProduitActifDTO> produitsActifs;

 // Constructeurs, getters et setters
 public WarehouseDetailsDTO() {}

 public WarehouseDetailsDTO(Warehouse warehouse, TypeWarehouseDTO type, 
                           List<EspaceDTO> espaceWarehouses, // <-- renommé
                           List<ProduitActifDTO> produitsActifs) {
     this.id = warehouse.getId();
     this.nom = warehouse.getNom();
     this.adresse = warehouse.getAdresse();
     this.email = warehouse.getEmail();
     this.nomResponsable = warehouse.getNomResponsable();
     this.mailResp = warehouse.getMailResp();
     this.telResp = warehouse.getTelResp();
     this.type = type;
     this.espaceWarehouses = espaceWarehouses; // <-- renommé
     this.produitsActifs = produitsActifs;
 }
 
 // Getters et setters pour tous les champs
 public Long getId() { return id; }
 public void setId(Long id) { this.id = id; }
 public String getNom() { return nom; }
 public void setNom(String nom) { this.nom = nom; }
 public String getAdresse() { return adresse; }
 public void setAdresse(String adresse) { this.adresse = adresse; }
 public String getEmail() { return email; }
 public void setEmail(String email) { this.email = email; }
 public String getNomResponsable() { return nomResponsable; }
 public void setNomResponsable(String nomResponsable) { this.nomResponsable = nomResponsable; }
 public String getMailResp() { return mailResp; }
 public void setMailResp(String mailResp) { this.mailResp = mailResp; }
 public String getTelResp() { return telResp; }
 public void setTelResp(String telResp) { this.telResp = telResp; }
 public TypeWarehouseDTO getType() { return type; }
 public void setType(TypeWarehouseDTO type) { this.type = type; }
 public List<EspaceDTO> getEspaceWarehouses() { return espaceWarehouses; }
 public void setEspaceWarehouses(List<EspaceDTO> espaceWarehouses) { this.espaceWarehouses = espaceWarehouses; }
 public List<ProduitActifDTO> getProduitsActifs() { return produitsActifs; }
 public void setProduitsActifs(List<ProduitActifDTO> produitsActifs) { this.produitsActifs = produitsActifs; }
}