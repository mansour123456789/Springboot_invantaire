package com.example.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class TypeWarehouse implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nomType;
    @JsonIgnore
    @OneToMany(mappedBy = "type")
    private List<Warehouse> warehouse = new ArrayList<>();

	public TypeWarehouse(String nomType, List<Warehouse> warehouse) {
		super();
		this.nomType = nomType;
		this.warehouse = warehouse;
	}

	public TypeWarehouse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomType() {
		return nomType;
	}

	public void setNomType(String nomType) {
		this.nomType = nomType;
	}

	public List<Warehouse> getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(List<Warehouse> warehouse) {
		this.warehouse = warehouse;
	}
    
    
    
    
    
    
}