package com.harvis.paymatix.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.harvis.paymatix.model.Admin;

public interface AdminRepository extends CrudRepository<Admin, Integer>{

	Optional<Admin> findByUserName(String userName);
	
}
