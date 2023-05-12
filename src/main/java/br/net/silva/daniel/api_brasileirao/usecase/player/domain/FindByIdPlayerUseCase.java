package br.net.silva.daniel.api_brasileirao.usecase.player.domain;

import br.net.silva.daniel.api_brasileirao.domain.player.domain.Player;
import br.net.silva.daniel.api_brasileirao.domain.player.exception.PlayerNotExistsException;
import br.net.silva.daniel.api_brasileirao.domain.shared.repository.FindByIdRepository;
import br.net.silva.daniel.api_brasileirao.domain.team.exception.TeamNotExistsException;
import br.net.silva.daniel.api_brasileirao.usecase.shared.interfaces.UseCase;

public class FindByIdPlayerUseCase implements UseCase<Player> {

    private final Long id;
    private final FindByIdRepository<Player> repository;

    public FindByIdPlayerUseCase(Long id, FindByIdRepository<Player> repository) {
        this.id = id;
        this.repository = repository;
    }

    @Override
    public Player execute() {
        try {
            return repository.findById(id);
        } catch (Exception e) {
            throw new PlayerNotExistsException();
        }
    }
}
