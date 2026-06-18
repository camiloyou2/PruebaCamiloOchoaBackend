
package com.cuadrangulaes.prueba.service;


import java.util.List;

import com.cuadrangulaes.prueba.dto.MatchDto;
import com.cuadrangulaes.prueba.dto.UpdateScoreDto;





public interface MatchService {
    List<MatchDto> getAll();
    MatchDto updateScore(Long id, UpdateScoreDto dto);
    void generateAndSaveMatches();
    MatchDto saveScore(UpdateScoreDto dto);

    
}