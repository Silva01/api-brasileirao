package br.net.silva.daniel.api_brasileirao.usecase.team.domain;

import br.net.silva.daniel.api_brasileirao.domain.shared.repository.FindAllRepository;
import br.net.silva.daniel.api_brasileirao.domain.shared.repository.SaveRepository;
import br.net.silva.daniel.api_brasileirao.domain.team.domain.Team;
import br.net.silva.daniel.api_brasileirao.infrastructure.ApiBrasileiraoApplication;
import br.net.silva.daniel.api_brasileirao.usecase.shared.interfaces.UseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = ApiBrasileiraoApplication.class)
class FindAllTeamsUseCaseTest {

    private final FindAllRepository<Team> findAllRepository;
    private final SaveRepository<Team> saveRepository;

    @Autowired
    FindAllTeamsUseCaseTest(FindAllRepository<Team> findAllRepository, SaveRepository<Team> saveRepository) {
        this.findAllRepository = findAllRepository;
        this.saveRepository = saveRepository;
    }

    @Test
    public void deve_retornar_todos_os_times() {
        UseCase<List<Team>> findAllTeamsUseCase = new FindAllTeamsUseCase(findAllRepository);
        UseCase<Team> saveTeamUseCase = new SaveTeamUseCase(saveRepository, new Team("Flamengo", "RJ"));

        saveTeamUseCase.execute();
        List<Team> response = findAllTeamsUseCase.execute();

        assertTrue(response.size() >= 1);
        assertEquals(response.get(0).getAggregate().getName(), "Flamengo");
        assertEquals(response.get(0).getAggregate().getLocalidade(), "RJ");
    }
}