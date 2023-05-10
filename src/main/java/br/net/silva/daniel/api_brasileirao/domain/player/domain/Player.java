package br.net.silva.daniel.api_brasileirao.domain.player.domain;

import br.net.silva.daniel.api_brasileirao.domain.shared.interfaces.Aggregate;

import java.time.LocalDate;

public class Player implements Aggregate<Player> {

    private final String name;
    private final LocalDate birthDate;
    private final String country;
    private final Long teamId;

    public Player(String name, LocalDate birthDate, String country, Long teamId) {
        this.name = name;
        this.birthDate = birthDate;
        this.country = country;
        this.teamId = teamId;
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

    @Override
    public Player getAggregate() {
        return this;
    }
}
