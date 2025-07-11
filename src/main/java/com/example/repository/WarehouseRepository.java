package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.model.Warehouse;
@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
	//@Query("SELECT w FROM Warehouse w WHERE w.typeWarehouse.id = :typeId")
	//List<Warehouse> findByType_Id(@Param("typeId") int typeId);
	
	List<Warehouse> findByType_Id(int id);
}
