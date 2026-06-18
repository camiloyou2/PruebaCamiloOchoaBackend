


package com.cuadrangulaes.prueba.serviceImpl;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuadrangulaes.prueba.dto.GroupDto;
import com.cuadrangulaes.prueba.dto.MatchDto;
import com.cuadrangulaes.prueba.entity.Group;
import com.cuadrangulaes.prueba.entity.Match;
import com.cuadrangulaes.prueba.entity.Team;
import com.cuadrangulaes.prueba.repository.GroupRepository;
import com.cuadrangulaes.prueba.repository.TeamRepository;
import com.cuadrangulaes.prueba.service.GroupService;
import com.cuadrangulaes.prueba.service.MatchService;




@Service


public class GroupServiceImpl implements GroupService {
	@Autowired
      TeamRepository teamRepository;
	@Autowired
      GroupRepository groupRepository;
	
	@Autowired
	private MatchService matchService;

	@Override
	public String performDraw() {

	 
	    groupRepository.deleteAll();



	   
	    List<Team> teams = teamRepository.findAll();

	  
	    Collections.shuffle(teams);

	
	    Group groupA = new Group();
	    groupA.setName("Group A");

	    Group groupB = new Group();
	    groupB.setName("Group B");

	    List<Team> groupATeams = new ArrayList<>();
	    List<Team> groupBTeams = new ArrayList<>();


	    for (int i = 0; i < teams.size(); i++) {
	        if (i % 2 == 0) {
	            groupATeams.add(teams.get(i));
	        } else {
	            groupBTeams.add(teams.get(i));
	        }
	    }

	    groupA.setTeams(groupATeams);
	    groupB.setTeams(groupBTeams);

	    // 5. Guardar grupos
	    groupRepository.save(groupA);
	    groupRepository.save(groupB);

	

	    return "Draw completed successfully";
	}
    
    
    
    @Override
    public List<GroupDto> getAll() {

        return groupRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }
    
 // ✅ Mapper method (Entity → DTO)
    private GroupDto mapToDTO(Group group) {
        return new GroupDto(
                group.getId(),
                group.getName(),
                group.getTeams()
                        .stream()
                        .map(team -> team.getName())
                        .toList()
        );
    }


}
