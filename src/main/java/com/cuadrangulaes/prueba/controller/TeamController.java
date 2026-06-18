
package com.cuadrangulaes.prueba.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cuadrangulaes.prueba.dto.TeamDto;
import com.cuadrangulaes.prueba.service.TeamService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "Team API", description = "Operations related to teams")
@CrossOrigin(origins = "http://localhost:50841")
@RestController
@RequestMapping("/api/teams")

public class TeamController {
	@Autowired
 TeamService teamService;

    @Operation(summary = "Create a new team")
    @PostMapping
    public ResponseEntity<TeamDto> create(
            @RequestBody TeamDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(teamService.create(dto));
    }

    
    @Operation(summary = "Get all teams")
    @GetMapping
    public ResponseEntity<List<TeamDto>> getAll() {
        return ResponseEntity.ok(
                teamService.getAll());
    }

    
    @Operation(summary = "Update a team by ID")
    @PutMapping("/{id}")
    public ResponseEntity<TeamDto> update(
            @PathVariable Long id,
            @RequestBody TeamDto dto) {
        return ResponseEntity.ok(
                teamService.update(id, dto));
    }

    
    
    @Operation(summary = "Delete a team by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {
        teamService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    
}
