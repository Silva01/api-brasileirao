package br.net.silva.daniel.api_brasileirao.infrastructure.component.player;

import br.net.silva.daniel.api_brasileirao.domain.player.domain.Player;
import br.net.silva.daniel.api_brasileirao.domain.shared.repository.FindByIdRepository;
import br.net.silva.daniel.api_brasileirao.infrastructure.service.PlayerService;
import org.springframework.stereotype.Component;

@Component
public class FindByIdPlayerRepositoryComponent {

    public FindByIdRepository<Player> createFindByIdRepository(PlayerService service) {
        return service;
    }
}
