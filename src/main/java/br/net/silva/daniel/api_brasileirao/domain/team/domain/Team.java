package br.net.silva.daniel.api_brasileirao.domain.team.domain;

public class Team {
    private final String name;
    private final String localidade;

    public Team(final String name, final String localidade) {
        this.name = name;
        this.localidade = localidade;
    }
}
