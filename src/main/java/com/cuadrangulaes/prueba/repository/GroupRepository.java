
package com.cuadrangulaes.prueba.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cuadrangulaes.prueba.entity.Group;


@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
	
	
	
}