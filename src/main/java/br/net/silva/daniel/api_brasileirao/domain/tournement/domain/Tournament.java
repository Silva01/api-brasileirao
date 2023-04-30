package br.net.silva.daniel.api_brasileirao.domain.tournement.domain;

import br.net.silva.daniel.api_brasileirao.domain.team.domain.Team;

import java.util.List;

public class Tournament {
    private final String name;
    private final List<Team> teams;

    public Tournament(String name, List<Team> teams) {
        this.name = name;
        this.teams = teams;
    }
}
