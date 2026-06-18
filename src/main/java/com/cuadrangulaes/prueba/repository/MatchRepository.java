
package com.cuadrangulaes.prueba.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cuadrangulaes.prueba.entity.Match;



@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
}