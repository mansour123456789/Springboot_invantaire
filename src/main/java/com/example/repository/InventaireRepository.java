package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Inventaire;
import com.example.model.Warehouse;
@Repository
public interface InventaireRepository extends JpaRepository<Inventaire, Long> {

}
