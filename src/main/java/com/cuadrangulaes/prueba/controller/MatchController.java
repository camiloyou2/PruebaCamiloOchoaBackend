
package com.cuadrangulaes.prueba.controller;


import org.springframework.http.ResponseEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cuadrangulaes.prueba.dto.MatchDto;
import com.cuadrangulaes.prueba.dto.UpdateScoreDto;
import com.cuadrangulaes.prueba.service.MatchService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Match API", description = "Operations related to matches")
@CrossOrigin(origins = "http://localhost:50841")
@RestController
@RequestMapping("/api/matches")


public class MatchController {
	@Autowired
	MatchService matchService;

    @Operation(summary = "Get all matches")
    @GetMapping
    public ResponseEntity<List<MatchDto>> getAll() {

        return ResponseEntity.ok(
                matchService.getAll());
    }

    @Operation(summary = "Update match score")
    @PutMapping("/{id}")
    public ResponseEntity<MatchDto> updateScore(
            @PathVariable Long id,
            @RequestBody UpdateScoreDto dto) {
        return ResponseEntity.ok(
                matchService.updateScore(id, dto));
    }
    
    
    
    @Operation(summary = "Registrar resultado")
    @PostMapping("/score")
    public ResponseEntity<MatchDto> saveScore(
            @RequestBody UpdateScoreDto dto) {

        return ResponseEntity.ok(
                matchService.saveScore(dto));
    }
}



