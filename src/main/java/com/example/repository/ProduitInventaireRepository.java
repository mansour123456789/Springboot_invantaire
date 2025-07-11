package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.ProduitInventaire;
import com.example.model.Warehouse;
@Repository
public interface ProduitInventaireRepository extends JpaRepository<ProduitInventaire, Long> {

}
