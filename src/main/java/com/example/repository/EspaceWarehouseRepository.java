package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.EspaceWarehouse;
import com.example.model.Warehouse;
@Repository
public interface EspaceWarehouseRepository extends JpaRepository<EspaceWarehouse, Long>  {
	// List<EspaceWarehouse> findByWarehouseIdIn(List<Long> warehouseIds);
    List<EspaceWarehouse> findByWarehouse_Id(Long warehouseId);
    List<EspaceWarehouse> findByWarehouseId(Long warehouseId);
}
