package br.net.silva.daniel.api_brasileirao.domain.player.dto;

import java.time.LocalDate;

public class PlayerDTO {

    private Long id;
    private String name;
    private LocalDate birthDate;
    private String country;
    private Long teamId;

    public PlayerDTO() {
    }

    public PlayerDTO(String name, LocalDate birthDate, String country, Long teamId, Long id) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.country = country;
        this.teamId = teamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
