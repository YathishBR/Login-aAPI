package com.callawaygolf.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.callawaygolf.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
	 Optional<User> findByEmail(String email);
	    Optional<User> findByUsernameOrEmail(String userName, String email);
	    Optional<User> findByUserName(String userName);
	    Boolean existsByUsername(String userName);
	    Boolean existsByEmail(String email);
}
