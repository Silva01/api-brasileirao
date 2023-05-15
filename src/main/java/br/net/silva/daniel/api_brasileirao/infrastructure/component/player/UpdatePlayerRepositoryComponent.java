package br.net.silva.daniel.api_brasileirao.infrastructure.component.player;

import br.net.silva.daniel.api_brasileirao.domain.player.domain.Player;
import br.net.silva.daniel.api_brasileirao.domain.shared.repository.UpdateRespository;
import br.net.silva.daniel.api_brasileirao.infrastructure.service.PlayerService;
import org.springframework.stereotype.Component;

@Component
public class UpdatePlayerRepositoryComponent {

    public UpdateRespository<Player> createFindAllRepository(PlayerService service) {
        return service;
    }
}
