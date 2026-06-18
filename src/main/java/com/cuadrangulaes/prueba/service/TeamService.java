
package com.cuadrangulaes.prueba.service;


import java.util.List;

import com.cuadrangulaes.prueba.dto.TeamDto;



public interface TeamService {
	
	TeamDto create(TeamDto dto);

    List<TeamDto> getAll();

    TeamDto update(Long id, TeamDto dto);

    void delete(Long id);
}