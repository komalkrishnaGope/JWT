package com.harvis.paymatix.repository;

import java.util.ArrayList;
//import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.harvis.paymatix.model.RoleActionMapping;

public interface RoleActionMappingRepository extends CrudRepository<RoleActionMapping, Integer> {

	@Query(value = "select * from roleactionmapping where role_role_id = :id", nativeQuery = true)
	ArrayList<RoleActionMapping> getByRoleId(@Param("id") int id);
	
	
}
