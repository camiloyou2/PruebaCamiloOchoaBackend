
package com.cuadrangulaes.prueba.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuadrangulaes.prueba.dto.MatchDto;
import com.cuadrangulaes.prueba.dto.UpdateScoreDto;
import com.cuadrangulaes.prueba.entity.Group;
import com.cuadrangulaes.prueba.entity.Match;
import com.cuadrangulaes.prueba.entity.Team;
import com.cuadrangulaes.prueba.repository.GroupRepository;
import com.cuadrangulaes.prueba.repository.MatchRepository;
import com.cuadrangulaes.prueba.service.MatchService;




@Service
public class MatchServiceImpl implements MatchService {
	
	@Autowired
 MatchRepository matchRepository;
	@Autowired
	 GroupRepository groupRepository;
    @Override

    
    public List<MatchDto> getAll() {

        List<Match> matches = matchRepository.findAll();

        // ✅ DEBUG: recorrer e imprimir
        for (Match m : matches) {

            if (m == null) {
                System.out.println("❌ MATCH ES NULL");
            } else {
                System.out.println("✅ Match ID: " + m.getId());

                if (m.getHomeTeam() == null) {
                    System.out.println("❌ HomeTeam es NULL en match " + m.getId());
                }

                if (m.getAwayTeam() == null) {
                    System.out.println("❌ AwayTeam es NULL en match " + m.getId());
                }

                if (m.getGroup() == null) {
                    System.out.println("⚠️ Group es NULL en match " + m.getId());
                }
            }
        }

        // ✅ luego haces el map
        return matches.stream()
                .filter(Objects::nonNull)
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    public MatchDto updateScore(Long id, UpdateScoreDto dto) {
        // 1. Find match
        Match match = matchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Match not found with id: " + id));

        // 2. Update scores
        match.setHomeGoals(dto.getHomeGoals());
        match.setAwayGoals(dto.getAwayGoals());

        // 3. Save updated match
        Match updatedMatch = matchRepository.save(match);

        // 4. Return DTO
        return mapToDTO(updatedMatch);
        
    }

    
    // ✅ Mapper method (Entity → DTO)
    private MatchDto mapToDTO(Match match) {

        if (match == null) return null;

        return new MatchDto(
                match.getId(),
                match.getHomeTeam() != null ? match.getHomeTeam().getName() : "N/A",
                match.getAwayTeam() != null ? match.getAwayTeam().getName() : "N/A",
                match.getHomeGoals(),
                match.getAwayGoals()
        );
    }
 
    
    

    
    
    
    @Override
    public void generateAndSaveMatches() {
        List<Group> groups = groupRepository.findAll();
        for (Group group : groups) {
            System.out.println("👉 Grupo: " + group.getName());
            List<Team> teams = group.getTeams();
            for (int i = 0; i < teams.size(); i++) {
                for (int j = i + 1; j < teams.size(); j++) {
                    Team home = teams.get(i);
                    Team away = teams.get(j);


                    Match match = new Match();
                    match.setHomeTeam(home);
                    match.setAwayTeam(away);
                    match.setHomeGoals(0);
                    match.setAwayGoals(0);
                    match.setGroup(group);

                    matchRepository.save(match);
                }
            }
        }
    }

	@Override
	public MatchDto saveScore(UpdateScoreDto dto) {
		// TODO Auto-generated method stub
		return null;
	}


}


