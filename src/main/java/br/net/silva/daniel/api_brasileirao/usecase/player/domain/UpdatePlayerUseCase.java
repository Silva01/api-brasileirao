package br.net.silva.daniel.api_brasileirao.usecase.player.domain;

import br.net.silva.daniel.api_brasileirao.domain.player.domain.Player;
import br.net.silva.daniel.api_brasileirao.domain.shared.repository.UpdateRespository;
import br.net.silva.daniel.api_brasileirao.usecase.shared.interfaces.UseCase;

public class UpdatePlayerUseCase implements UseCase<Player> {

    private final UpdateRespository<Player> repository;
    private final Player team;

    public UpdatePlayerUseCase(UpdateRespository<Player> repository, Player team) {
        this.repository = repository;
        this.team = team;
    }

    @Override
    public Player execute() {
        return repository.update(team);
    }
}
