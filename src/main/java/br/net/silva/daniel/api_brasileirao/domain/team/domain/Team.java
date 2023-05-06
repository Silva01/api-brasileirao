package br.net.silva.daniel.api_brasileirao.domain.team.domain;

import br.net.silva.daniel.api_brasileirao.domain.shared.interfaces.Aggregate;
import br.net.silva.daniel.api_brasileirao.domain.team.dto.TeamDTO;

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

    public TeamDTO toDTO() {
        TeamDTO dto = new TeamDTO();
        dto.setName(this.name);
        dto.setLocalidade(this.localidade);
        return dto;
    }
}
