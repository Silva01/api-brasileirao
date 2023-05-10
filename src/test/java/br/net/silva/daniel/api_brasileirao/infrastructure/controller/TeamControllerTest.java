package br.net.silva.daniel.api_brasileirao.infrastructure.controller;

import br.net.silva.daniel.api_brasileirao.infrastructure.ApiBrasileiraoApplication;
import br.net.silva.daniel.api_brasileirao.infrastructure.dto.BodyTeamDTO;
import br.net.silva.daniel.api_brasileirao.infrastructure.model.TeamModel;
import br.net.silva.daniel.api_brasileirao.infrastructure.repository.TeamRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = { ApiBrasileiraoApplication.class, TeamController.class }, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc(printOnlyOnFailure = false)
class TeamControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TeamRepository teamRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void contextLoads() {
        TeamModel teamModel = new TeamModel();
        teamModel.setName("Recife");
        teamModel.setLocalidade("PE");

        teamRepository.save(teamModel);
    }

    @Test
    void create() throws Exception {
        BodyTeamDTO bodyTeamDTO = new BodyTeamDTO();
        bodyTeamDTO.setName("Brasília");
        bodyTeamDTO.setLocalidade("DF");

        mockMvc.perform(post("/team")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(bodyTeamDTO)))
                .andExpect(status().isCreated());
    }

    @Test
    void listAll() throws Exception {

        MvcResult mvcResult = this.mockMvc.perform(get("/team"))
                .andReturn();

        mvcResult.getAsyncResult();

        this.mockMvc.perform(asyncDispatch(mvcResult))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$", Matchers.hasSize(Matchers.greaterThanOrEqualTo(1))));
    }

    @Test
    void findById() throws Exception {

        MvcResult mvcResult = this.mockMvc.perform(get("/team/{id}", 1))
                .andReturn();

        mvcResult.getAsyncResult();

        this.mockMvc.perform(asyncDispatch(mvcResult))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name", Matchers.is("Recife")))
                .andExpect(jsonPath("$.localidade", Matchers.is("PE")))
                .andExpect(jsonPath("$.id", Matchers.is(1)));
    }

    @Test
    void update() throws Exception {
        mockMvc.perform(put("/team/{id}", 1)
                        .content("{\"name\": \"Recife\", \"localidade\": \"PE\"}")
                        .contentType("application/json"))
                .andExpect(status().isNoContent());
    }

    @Test
    void delete_request() throws Exception {
        mockMvc.perform(delete("/team/{id}", 1))
                .andExpect(status().isNoContent());
    }
}