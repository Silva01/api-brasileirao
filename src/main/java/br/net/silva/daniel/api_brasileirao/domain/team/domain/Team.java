package br.net.silva.daniel.api_brasileirao.domain.team.domain;

import br.net.silva.daniel.api_brasileirao.domain.shared.interfaces.Aggregate;

public class Team implements Aggregate<Team> {
    private final String name;
    private final String localidade;

    public Team(final String name, final String localidade) {
        this.name = name;
        this.localidade = localidade;
    }

    public String getName() {
        return name;
    }

    public String getLocalidade() {
        return localidade;
    }
    @Override
    public Team getAggregate() {
        return this;
    }
}
