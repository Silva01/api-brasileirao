package br.net.silva.daniel.api_brasileirao.infrastructure.component.player;

import br.net.silva.daniel.api_brasileirao.domain.player.domain.Player;
import br.net.silva.daniel.api_brasileirao.domain.shared.repository.SaveRepository;
import br.net.silva.daniel.api_brasileirao.domain.team.domain.Team;
import br.net.silva.daniel.api_brasileirao.infrastructure.repository.PlayerRepository;
import br.net.silva.daniel.api_brasileirao.infrastructure.service.PlayerService;
import br.net.silva.daniel.api_brasileirao.infrastructure.service.TeamService;
import org.springframework.stereotype.Component;

@Component
public class SaveRepositoryComponent {
    public SaveRepository<Player> createSaveRepository(PlayerService service) {
        return service;
    }
}
