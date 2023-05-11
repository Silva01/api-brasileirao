package br.net.silva.daniel.api_brasileirao.domain.player.domain;

import br.net.silva.daniel.api_brasileirao.domain.shared.interfaces.Aggregate;

import java.time.LocalDate;

public class Player implements Aggregate<Player> {

    private Long id;
    private final String name;
    private final LocalDate birthDate;
    private final String country;
    private final Long teamId;

    public Player(String name, LocalDate birthDate, String country, Long teamId, Long id) {
        this.name = name;
        this.birthDate = birthDate;
        this.country = country;
        this.teamId = teamId;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getCountry() {
        return country;
    }

    public Long getTeamId() {
        return teamId;
    }

    public Long getId() {
        return id;
    }

    @Override
    public Player getAggregate() {
        return this;
    }
}
