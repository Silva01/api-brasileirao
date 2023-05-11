package br.net.silva.daniel.api_brasileirao.usecase.player.domain;

import br.net.silva.daniel.api_brasileirao.domain.player.domain.Player;
import br.net.silva.daniel.api_brasileirao.domain.shared.interfaces.Aggregate;
import br.net.silva.daniel.api_brasileirao.domain.shared.repository.SaveRepository;
import br.net.silva.daniel.api_brasileirao.usecase.shared.interfaces.UseCase;

public class SavePlayerUseCase implements UseCase<Player> {

    private final SaveRepository<Player> repository;
    private final Aggregate<Player> player;

    public SavePlayerUseCase(SaveRepository<Player> repository, Aggregate<Player> player) {
        this.repository = repository;
        this.player = player;
    }


    @Override
    public Player execute() {
        return repository.save(player.getAggregate());
    }
}
