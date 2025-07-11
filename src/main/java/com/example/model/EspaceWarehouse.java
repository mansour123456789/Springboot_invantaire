package com.example.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class EspaceWarehouse implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String idTag;
    private String nomResponsable;
    private String mailResp;
    private String telResp;
   
    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;

    @JsonIgnore
    @OneToMany(mappedBy = "espace")
    private List<ProduitWarehouse> produits = new ArrayList<>();
    @JsonIgnore
    @ManyToMany(mappedBy = "espaces")
    private List<Inventaire> inventaires = new ArrayList<>();

    
    
    
    
    
    
	public EspaceWarehouse() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdTag() {
		return idTag;
	}

	public void setIdTag(String idTag) {
		this.idTag = idTag;
	}

	public String getNomResponsable() {
		return nomResponsable;
	}

	public void setNomResponsable(String nomResponsable) {
		this.nomResponsable = nomResponsable;
	}

	public String getMailResp() {
		return mailResp;
	}

	public void setMailResp(String mailResp) {
		this.mailResp = mailResp;
	}

	public String getTelResp() {
		return telResp;
	}

	public void setTelResp(String telResp) {
		this.telResp = telResp;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public List<ProduitWarehouse> getProduits() {
		return produits;
	}

	public void setProduits(List<ProduitWarehouse> produits) {
		this.produits = produits;
	}

	public List<Inventaire> getInventaires() {
		return inventaires;
	}

	public void setInventaires(List<Inventaire> inventaires) {
		this.inventaires = inventaires;
	}

	public EspaceWarehouse(String idTag, String nomResponsable, String mailResp, String telResp, Warehouse warehouse,
			List<ProduitWarehouse> produits, List<Inventaire> inventaires) {
		super();
		this.idTag = idTag;
		this.nomResponsable = nomResponsable;
		this.mailResp = mailResp;
		this.telResp = telResp;
		this.warehouse = warehouse;
		this.produits = produits;
		this.inventaires = inventaires;
	}
    
    
    
    
    
    
    
    
}