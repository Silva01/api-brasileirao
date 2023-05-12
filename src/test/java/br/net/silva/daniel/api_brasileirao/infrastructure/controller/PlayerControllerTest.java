package br.net.silva.daniel.api_brasileirao.infrastructure.controller;

import br.net.silva.daniel.api_brasileirao.infrastructure.ApiBrasileiraoApplication;
import br.net.silva.daniel.api_brasileirao.infrastructure.dto.BodyPlayerDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = {ApiBrasileiraoApplication.class, PlayerController.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc(printOnlyOnFailure = false)
class PlayerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void should_create_a_new_player_request() throws Exception {
        BodyPlayerDTO bodyPlayerDTO = new BodyPlayerDTO();
        bodyPlayerDTO.setName("Daniel");
        bodyPlayerDTO.setTeamId(1L);
        bodyPlayerDTO.setCountry("Brasil");
        bodyPlayerDTO.setBirthDate(LocalDate.of(1995, 10, 10));

        mockMvc.perform(post("/player")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(bodyPlayerDTO)))
                .andExpect(status().isCreated());

        MvcResult mvcResult = mockMvc.perform(get("/player").contentType("application/json")).andReturn();

        mvcResult.getAsyncResult();

        mockMvc.perform(asyncDispatch(mvcResult))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Daniel"))
                .andExpect(jsonPath("$[0].teamId").value(1L))
                .andExpect(jsonPath("$[0].country").value("Brasil"))
                .andExpect(jsonPath("$[0].birthDate").value("1995-10-10"));
    }

    @Test
    void update() throws Exception {
        BodyPlayerDTO bodyPlayerDTO = new BodyPlayerDTO();
        bodyPlayerDTO.setName("Daniel");
        bodyPlayerDTO.setTeamId(1L);
        bodyPlayerDTO.setCountry("Brasil");
        bodyPlayerDTO.setBirthDate(LocalDate.of(1995, 10, 10));

        mockMvc.perform(post("/player")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(bodyPlayerDTO)))
                .andExpect(status().isCreated());

        MvcResult mvcResult = mockMvc.perform(get("/player").contentType("application/json")).andReturn();

        mvcResult.getAsyncResult();

        mockMvc.perform(asyncDispatch(mvcResult))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Daniel"))
                .andExpect(jsonPath("$[0].teamId").value(1L))
                .andExpect(jsonPath("$[0].country").value("Brasil"))
                .andExpect(jsonPath("$[0].birthDate").value("1995-10-10"));


        bodyPlayerDTO.setName("Daniel Silva");
        bodyPlayerDTO.setTeamId(1L);
        bodyPlayerDTO.setCountry("Germany");
        bodyPlayerDTO.setBirthDate(LocalDate.of(1995, 10, 10));

        mockMvc.perform(put("/player/1")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(bodyPlayerDTO)))
                .andExpect(status().isNoContent());

        MvcResult mvcResult2 = mockMvc.perform(get("/player").contentType("application/json")).andReturn();

        mvcResult2.getAsyncResult();

        mockMvc.perform(asyncDispatch(mvcResult2))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Daniel Silva"))
                .andExpect(jsonPath("$[0].teamId").value(1L))
                .andExpect(jsonPath("$[0].country").value("Germany"))
                .andExpect(jsonPath("$[0].birthDate").value("1995-10-10"));
    }

    @Test
    void delete_request() throws Exception {
        BodyPlayerDTO bodyPlayerDTO = new BodyPlayerDTO();
        bodyPlayerDTO.setName("Daniel");
        bodyPlayerDTO.setTeamId(1L);
        bodyPlayerDTO.setCountry("Brasil");
        bodyPlayerDTO.setBirthDate(LocalDate.of(1995, 10, 10));

        mockMvc.perform(post("/player")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(bodyPlayerDTO)))
                .andExpect(status().isCreated());


        MvcResult mvcResult1 = mockMvc.perform(get("/player/1").contentType("application/json")).andReturn();

        mvcResult1.getAsyncResult();

        mockMvc.perform(asyncDispatch(mvcResult1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Daniel"))
                .andExpect(jsonPath("$[0].teamId").value(1L))
                .andExpect(jsonPath("$[0].country").value("Brasil"))
                .andExpect(jsonPath("$[0].birthDate").value("1995-10-10"));


        mockMvc.perform(delete("/player/1").contentType("application/json"))
                .andExpect(status().isNoContent());


        MvcResult mvcResult = mockMvc.perform(get("/player/1").contentType("application/json")).andReturn();

        mvcResult.getAsyncResult();

        mockMvc.perform(asyncDispatch(mvcResult))
                .andExpect(status().isNotFound())
                .andExpect(content().string(""));
    }

    @Test
    void findById() throws Exception {
        BodyPlayerDTO bodyPlayerDTO = new BodyPlayerDTO();
        bodyPlayerDTO.setName("Daniel");
        bodyPlayerDTO.setTeamId(1L);
        bodyPlayerDTO.setCountry("Brasil");
        bodyPlayerDTO.setBirthDate(LocalDate.of(1995, 10, 10));

        mockMvc.perform(post("/player")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(bodyPlayerDTO)))
                .andExpect(status().isCreated());

        MvcResult mvcResult = mockMvc.perform(get("/player/1").contentType("application/json")).andReturn();

        mvcResult.getAsyncResult();

        mockMvc.perform(asyncDispatch(mvcResult))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"id\":1,\"name\":\"Daniel\",\"birthDate\":\"1995-10-10\",\"country\":\"Brasil\",\"teamId\":1}"));
    }

    @Test
    void findAll() throws Exception {
        BodyPlayerDTO bodyPlayerDTO = new BodyPlayerDTO();
        bodyPlayerDTO.setName("Daniel");
        bodyPlayerDTO.setTeamId(1L);
        bodyPlayerDTO.setCountry("Brasil");
        bodyPlayerDTO.setBirthDate(LocalDate.of(1995, 10, 10));

        mockMvc.perform(post("/player")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(bodyPlayerDTO)))
                .andExpect(status().isCreated());

        MvcResult mvcResult = mockMvc.perform(get("/player").contentType("application/json")).andReturn();

        mvcResult.getAsyncResult();

        mockMvc.perform(asyncDispatch(mvcResult))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Daniel"))
                .andExpect(jsonPath("$[0].teamId").value(1L))
                .andExpect(jsonPath("$[0].country").value("Brasil"))
                .andExpect(jsonPath("$[0].birthDate").value("1995-10-10"));
    }
}