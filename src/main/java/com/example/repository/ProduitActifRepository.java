package com.example.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dto.WarehouseDetailsDTO;
import com.example.model.ProduitActif;
import com.example.model.Warehouse;
@Repository
public interface ProduitActifRepository extends JpaRepository<ProduitActif, Long> {
	// List<ProduitActif> findByWarehouseIdIn(List<Long> warehouseIds);

	// Collection<WarehouseDetailsDTO> findByWarehouseIdIn(List<Long> warehouseIds);
}
