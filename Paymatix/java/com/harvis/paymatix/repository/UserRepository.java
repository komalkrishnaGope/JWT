package com.harvis.paymatix.repository;

import java.util.Date;
import java.util.Optional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import com.harvis.paymatix.model.Users;

public interface UserRepository extends CrudRepository<Users, Integer> {
	
	Optional<Users> findByUserName(String userName);
	
	Optional<Users> findByEmail(String email);
	
	@Modifying
	@Transactional
	@Query(value = "update users set email = :email, modified_date = :modifiedDate where user_id = :userId", nativeQuery = true)
	void editUser(int userId, String email, Date modifiedDate);
	
	@Modifying
	@Transactional
	@Query(value = "update users set is_active = '0' where user_id = :userId", nativeQuery = true)
	void deactivateUser(int userId);
	
	@Modifying
	@Transactional
	@Query(value = "update users set is_active = '1' where user_id = :userId", nativeQuery = true)
	void activateUser(int userId);
	
	@Modifying
	@Transactional
	@Query(value = "update users set password = :password where user_id = :userId", nativeQuery = true)
	void resetPassword(int userId, String password);
	
	@Query(value = "select * from users where user_name = :username", nativeQuery = true)
	Optional<Users> getUserName(String username);
	
}
