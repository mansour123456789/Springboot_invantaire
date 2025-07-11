package com.example.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

import jakarta.persistence.JoinColumn;
@Entity
public class Inventaire implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private String nom;
    private Integer nbInventaire;
    private String description;
    @JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "inventaire_espace",
        joinColumns = @JoinColumn(name = "inventaire_id"),
        inverseJoinColumns = @JoinColumn(name = "espace_id"))
    private List<EspaceWarehouse> espaces = new ArrayList<>();
    @JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "inventaire_user",
        joinColumns = @JoinColumn(name = "inventaire_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> utilisateurs = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "inventaire")
    private List<ProduitInventaire> produits = new ArrayList<>();

	public Inventaire(Date date, String nom, Integer nbInventaire, String description, List<EspaceWarehouse> espaces,
			List<User> utilisateurs, List<ProduitInventaire> produits) {
		super();
		this.date = date;
		this.nom = nom;
		this.nbInventaire = nbInventaire;
		this.description = description;
		this.espaces = espaces;
		this.utilisateurs = utilisateurs;
		this.produits = produits;
	}
	
	

	public Inventaire() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getNbInventaire() {
		return nbInventaire;
	}

	public void setNbInventaire(Integer nbInventaire) {
		this.nbInventaire = nbInventaire;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<EspaceWarehouse> getEspaces() {
		return espaces;
	}

	public void setEspaces(List<EspaceWarehouse> espaces) {
		this.espaces = espaces;
	}

	public List<User> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(List<User> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public List<ProduitInventaire> getProduits() {
		return produits;
	}

	public void setProduits(List<ProduitInventaire> produits) {
		this.produits = produits;
	}
    
    
    
    
    
    
    
}