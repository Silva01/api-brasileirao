package br.net.silva.daniel.api_brasileirao.domain.player.domain;

import br.net.silva.daniel.api_brasileirao.domain.shared.interfaces.Aggregate;
import br.net.silva.daniel.api_brasileirao.domain.team.domain.Team;

import java.time.LocalDate;

public class Player implements Aggregate<Player> {

    private final String name;
    private final LocalDate birthDate;
    private final String country;
    private final Team team;

    public Player(String name, LocalDate birthDate, String country, Team team) {
        this.name = name;
        this.birthDate = birthDate;
        this.country = country;
        this.team = team;
    }

    @Override
    public Player getAggregate() {
        return this;
    }
}
