package br.net.silva.daniel.api_brasileirao.usecase.team.domain;

import br.net.silva.daniel.api_brasileirao.domain.shared.repository.FindByIdRepository;
import br.net.silva.daniel.api_brasileirao.domain.shared.repository.SaveRepository;
import br.net.silva.daniel.api_brasileirao.domain.shared.repository.UpdateRespository;
import br.net.silva.daniel.api_brasileirao.domain.team.domain.Team;
import br.net.silva.daniel.api_brasileirao.infrastructure.ApiBrasileiraoApplication;
import br.net.silva.daniel.api_brasileirao.usecase.team.interfaces.UseCase;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ApiBrasileiraoApplication.class)
class UpdateTeamUseCaseTest {

    private final SaveRepository<Team> saveRepository;
    private final UpdateRespository<Team> updateRepository;
    private final FindByIdRepository<Team> findByIdRepository;

    UpdateTeamUseCaseTest(SaveRepository<Team> saveRepository, UpdateRespository<Team> updateRepository, FindByIdRepository<Team> findByIdRepository) {
        this.saveRepository = saveRepository;
        this.updateRepository = updateRepository;
        this.findByIdRepository = findByIdRepository;
    }

    @Test
    void deve_atualizar_um_time() {

        UseCase<Team> createTeamUseCase = new SaveTeamUseCase(saveRepository, new Team("Flamengo", "RJ"));
        Team teamCreated = createTeamUseCase.execute();

        UseCase<Team> updateTeamUseCase = new UpdateTeamUseCase(updateRepository, new Team("Sport Recife", "PE", teamCreated.getId()));
        Team teamUpdated = updateTeamUseCase.execute();

        UseCase<Team> findTeamUseCase = new FindByIdTeamUseCase(teamCreated.getId(), findByIdRepository);
        Team teamFinded = findTeamUseCase.execute();

        assertNotNull(teamFinded);
        assertEquals(teamFinded.getName(), "Sport Recife");
        assertEquals(teamFinded.getLocalidade(), "PE");

        assertEquals(teamFinded.getId(), teamCreated.getId());

        assertEquals(teamFinded.getId(), teamUpdated.getId());
        assertEquals(teamFinded.getName(), teamUpdated.getName());
        assertEquals(teamFinded.getLocalidade(), teamUpdated.getLocalidade());


    }

}