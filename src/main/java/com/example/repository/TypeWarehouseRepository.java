package com.example.repository;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dto.WarehouseDetailsDTO;
import com.example.model.TypeWarehouse;
import com.example.model.Warehouse;
@Repository
public interface TypeWarehouseRepository extends JpaRepository<TypeWarehouse, Integer >{

	//Collection<WarehouseDetailsDTO> findAllByIdl(Map<Integer, List<Warehouse>> grouped);

}
