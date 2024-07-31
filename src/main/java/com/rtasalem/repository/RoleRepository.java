package com.rtasalem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rtasalem.models.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	
	Optional<Role> findByAuthority(String authority);

}
