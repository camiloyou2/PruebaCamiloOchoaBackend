
package com.cuadrangulaes.prueba.dto;



public class UpdateScoreDto {

    private Integer homeGoals;
    private Integer awayGoals;

    public UpdateScoreDto() {}

    public Integer getHomeGoals() {
        return homeGoals;
    }

    public Integer getAwayGoals() {
        return awayGoals;
    }

    public void setHomeGoals(Integer homeGoals) {
        this.homeGoals = homeGoals;
    }

    public void setAwayGoals(Integer awayGoals) {
        this.awayGoals = awayGoals;
    }
}