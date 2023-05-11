package br.net.silva.daniel.api_brasileirao.infrastructure.component.player;

import br.net.silva.daniel.api_brasileirao.domain.player.domain.Player;
import br.net.silva.daniel.api_brasileirao.domain.shared.repository.SaveRepository;
import br.net.silva.daniel.api_brasileirao.infrastructure.service.PlayerService;
import org.springframework.stereotype.Component;

@Component
public class SavePlayerRepositoryComponent {
    public SaveRepository<Player> createSaveRepository(PlayerService service) {
        return service;
    }
}
