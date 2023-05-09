package br.net.silva.daniel.api_brasileirao.infrastructure.component.team;

import br.net.silva.daniel.api_brasileirao.domain.shared.repository.UpdateRespository;
import br.net.silva.daniel.api_brasileirao.domain.team.domain.Team;
import br.net.silva.daniel.api_brasileirao.infrastructure.service.TeamService;
import org.springframework.stereotype.Component;

@Component
public class UpdateRepositoryComponent {

    public UpdateRespository<Team> createFindAllRepository(TeamService service) {
        return service;
    }
}
