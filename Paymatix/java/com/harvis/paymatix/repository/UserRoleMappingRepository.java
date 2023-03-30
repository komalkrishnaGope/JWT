package com.harvis.paymatix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.harvis.paymatix.model.UserRoleMapping;

public interface UserRoleMappingRepository extends CrudRepository<UserRoleMapping, String> {
	
	@Query(value = "select * from userrolemapping where user_user_id = :id", nativeQuery = true)
	List<UserRoleMapping> getByUserId(@Param("id") int id);

	@Modifying
	@Transactional
	@Query(value = "insert into userrolemapping (user_user_id, role_role_id) values  (:userId, :roleId)", nativeQuery = true)
	void createUserRole(int userId, int roleId);
	
	@Modifying
	@Transactional
	@Query(value = "delete from userrolemapping where user_user_id = :userId", nativeQuery = true)
	void deleteAllRoles(int userId);
	
}
