package br.net.silva.daniel.api_brasileirao.usecase.team.domain;

import br.net.silva.daniel.api_brasileirao.domain.shared.repository.FindByIdRepository;
import br.net.silva.daniel.api_brasileirao.domain.shared.repository.SaveRepository;
import br.net.silva.daniel.api_brasileirao.domain.team.domain.Team;
import br.net.silva.daniel.api_brasileirao.infrastructure.ApiBrasileiraoApplication;
import br.net.silva.daniel.api_brasileirao.usecase.team.interfaces.UseCase;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ApiBrasileiraoApplication.class)
class FindByIdTeamUseCaseTest {

    private final SaveRepository<Team> saveRepository;
    private final FindByIdRepository<Team> findByIdRepository;

    @Autowired
    FindByIdTeamUseCaseTest(SaveRepository<Team> saveRepository, FindByIdRepository<Team> findByIdRepository) {
        this.saveRepository = saveRepository;
        this.findByIdRepository = findByIdRepository;
    }

    @Test
    void deve_retornar_um_time() {
        UseCase<Team> saveTeamUseCase = new SaveTeamUseCase(saveRepository, new Team("Flamengo", "RJ"));
        UseCase<Team> findByIdTeamUseCase = new FindByIdTeamUseCase(saveTeamUseCase.execute().getAggregate().getId(), findByIdRepository);

        Team response = findByIdTeamUseCase.execute();

        assertNotNull(response);

        assertEquals(1, response.getAggregate().getId());
        assertEquals(response.getAggregate().getName(), "Flamengo");
        assertEquals(response.getAggregate().getLocalidade(), "RJ");
    }
}