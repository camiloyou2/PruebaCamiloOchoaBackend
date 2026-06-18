
package com.cuadrangulaes.prueba.controller;



import org.springframework.http.ResponseEntity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cuadrangulaes.prueba.dto.GroupDto;
import com.cuadrangulaes.prueba.service.GroupService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "Group API", description = "Operations related to groups and draw")
@CrossOrigin(origins = "http://localhost:50841")
@RestController
@RequestMapping("/api/groups")


public class GroupController {
	@Autowired
    GroupService groupService;

    @Operation(summary = "Perform draw and create groups")
    @PostMapping("/draw")
    public ResponseEntity<String> drawTeams() {

        groupService.performDraw();

        return ResponseEntity.ok(
                "Draw completed successfully"
        );
    }
    @Operation(summary = "Get all groups with teams")
    @GetMapping
    public ResponseEntity<List<GroupDto>> getAll() {
        List<GroupDto> groups = groupService.getAll();
        return ResponseEntity.ok(groups);
    }
}