package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.ProduitWarehouse;
import com.example.model.Warehouse;
@Repository
public interface ProduitWarehouseRepository extends JpaRepository<ProduitWarehouse, Long> {
    List<ProduitWarehouse> findByEspace_Id(Long espaceId);
    List<ProduitWarehouse> findByEspaceId(Long espaceId);
}
