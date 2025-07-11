package com.example.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ProduitWarehouse implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomProduit;
    private String rfidTag;
    private String tag;

    @ManyToOne
    @JoinColumn(name = "espace_id")
    private EspaceWarehouse espace;

	public ProduitWarehouse(String nomProduit, String rfidTag, String tag, EspaceWarehouse espace) {
		super();
		this.nomProduit = nomProduit;
		this.rfidTag = rfidTag;
		this.tag = tag;
		this.espace = espace;
	}

	public ProduitWarehouse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomProduit() {
		return nomProduit;
	}

	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}

	public String getRfidTag() {
		return rfidTag;
	}

	public void setRfidTag(String rfidTag) {
		this.rfidTag = rfidTag;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public EspaceWarehouse getEspace() {
		return espace;
	}

	public void setEspace(EspaceWarehouse espace) {
		this.espace = espace;
	}
    
    
    
}