package br.net.silva.daniel.api_brasileirao.usecase.player.domain;

import br.net.silva.daniel.api_brasileirao.domain.player.domain.Player;
import br.net.silva.daniel.api_brasileirao.domain.shared.interfaces.Aggregate;
import br.net.silva.daniel.api_brasileirao.domain.shared.repository.SaveRepository;
import br.net.silva.daniel.api_brasileirao.usecase.shared.interfaces.UseCase;

public class SavePlayerUseCase implements UseCase<Player> {

    private final SaveRepository<Player> repository;
    private final Aggregate<Player> team;

    public SavePlayerUseCase(SaveRepository<Player> repository, Aggregate<Player> team) {
        this.repository = repository;
        this.team = team;
    }


    @Override
    public Player execute() {
        return repository.save(team.getAggregate());
    }
}
