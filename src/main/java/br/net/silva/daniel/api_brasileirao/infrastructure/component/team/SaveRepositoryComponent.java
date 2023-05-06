package br.net.silva.daniel.api_brasileirao.infrastructure.component.team;

import br.net.silva.daniel.api_brasileirao.domain.shared.repository.SaveRepository;
import br.net.silva.daniel.api_brasileirao.domain.team.domain.Team;
import br.net.silva.daniel.api_brasileirao.infrastructure.service.TeamService;
import org.springframework.stereotype.Component;

@Component
public class SaveRepositoryComponent {
    public SaveRepository<Team> createSaveRepository(TeamService service) {
        return service;
    }
}
