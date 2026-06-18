package com.cuadrangulaes.prueba.dto;

import java.util.List;

public class GroupDto {

    private Long id;
    private String name;
    private List<String> teams;

    public GroupDto() {
    }

    public GroupDto(Long id, String name, List<String> teams) {
        this.id = id;
        this.name = name;
        this.teams = teams;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getTeams() {
        return teams;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeams(List<String> teams) {
        this.teams = teams;
    }
}
