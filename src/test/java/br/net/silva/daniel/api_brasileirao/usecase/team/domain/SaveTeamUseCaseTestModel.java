package br.net.silva.daniel.api_brasileirao.usecase.team.domain;

import br.net.silva.daniel.api_brasileirao.domain.shared.repository.SaveRepository;
import br.net.silva.daniel.api_brasileirao.domain.team.domain.Team;
import br.net.silva.daniel.api_brasileirao.infrastructure.ApiBrasileiraoApplication;
import br.net.silva.daniel.api_brasileirao.usecase.team.interfaces.UseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = ApiBrasileiraoApplication.class)
class SaveTeamUseCaseTestModel {

    private SaveRepository<Team> saveRepository;

    @Autowired
    SaveTeamUseCaseTestModel(SaveRepository<Team> saveRepository) {
        this.saveRepository = saveRepository;
    }

    @Test
    void deve_salvar_um_time() {
        UseCase<Team> useCase = new SaveTeamUseCase(saveRepository, new Team("Flamengo", "RJ"));
        Team response = useCase.execute();

        assertEquals(response.getName(), "Flamengo");
        assertEquals(response.getLocalidade(), "RJ");
    }
}