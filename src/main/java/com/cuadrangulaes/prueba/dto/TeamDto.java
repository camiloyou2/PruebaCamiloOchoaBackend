
package com.cuadrangulaes.prueba.dto;



public class TeamDto {


    private Long id;
    private String name;

    public TeamDto() {
    }

    public TeamDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}