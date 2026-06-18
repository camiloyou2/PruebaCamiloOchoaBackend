
package com.cuadrangulaes.prueba.serviceImpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuadrangulaes.prueba.dto.TeamDto;
import com.cuadrangulaes.prueba.entity.Team;
import com.cuadrangulaes.prueba.repository.TeamRepository;
import com.cuadrangulaes.prueba.service.TeamService;





@Service
public class TeamServiceImpl   implements TeamService {
	@Autowired
    TeamRepository teamRepository;

    @Override
    public TeamDto create(TeamDto dto) {
        Team team = mapToEntity(dto);
        Team savedTeam = teamRepository.save(team);
        return mapToDto(savedTeam);
    }

    @Override
    public List<TeamDto> getAll() {
        return teamRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public TeamDto update(Long id, TeamDto dto) {

        Team team = teamRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Team not found"));

        team.setName(dto.getName());

        Team updatedTeam = teamRepository.save(team);

        return mapToDto(updatedTeam);
    }

    @Override
    public void delete(Long id) {
        Team team = teamRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Team not found"));
        teamRepository.delete(team);
    }

   
    
    
    

    private Team mapToEntity(TeamDto dto) {
        Team team = new Team();
        team.setId(dto.getId());
        team.setName(dto.getName());
        return team;
    }

    private TeamDto mapToDto(Team team) {
        return new TeamDto(
                team.getId(),
                team.getName()
        );
    }
}