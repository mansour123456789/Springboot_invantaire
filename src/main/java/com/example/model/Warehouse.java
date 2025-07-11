package com.example.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Warehouse implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String adresse;
    private String email;
    private String nomResponsable;
    private String mailResp;
    private String telResp;
    @JsonIgnore
    @OneToMany(mappedBy = "warehouse")
    private List<EspaceWarehouse> espaces = new ArrayList<>();
    @JsonIgnoreProperties("warehouses")
    @ManyToOne(optional = false)
    @JoinColumn(name = "type_id", nullable = false)
    private TypeWarehouse type;
    @JsonIgnore
    @OneToMany(mappedBy = "warehouse")
    private List<ProduitActif> produitsActifs = new ArrayList<>();

	public Warehouse(String nom, String adresse, String email, String nomResponsable, String mailResp, String telResp,
			List<EspaceWarehouse> espaces, TypeWarehouse type, List<ProduitActif> produitsActifs) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.email = email;
		this.nomResponsable = nomResponsable;
		this.mailResp = mailResp;
		this.telResp = telResp;
		this.espaces = espaces;
		this.type = type;
		this.produitsActifs = produitsActifs;
	}

	public Warehouse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public List<EspaceWarehouse> getEspaces() {
		return espaces;
	}

	public void setEspaces(List<EspaceWarehouse> espaces) {
		this.espaces = espaces;
	}

	public TypeWarehouse getType() {
		return type;
	}

	public void setType(TypeWarehouse type) {
		this.type = type;
	}

	public List<ProduitActif> getProduitsActifs() {
		return produitsActifs;
	}

	public void setProduitsActifs(List<ProduitActif> produitsActifs) {
		this.produitsActifs = produitsActifs;
	}

	
    
    
    
    
}