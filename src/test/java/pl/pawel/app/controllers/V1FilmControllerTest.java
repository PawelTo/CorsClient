package pl.pawel.app.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.pawel.app.domain.FilmRepository;
import pl.pawel.app.domain.models.Film;

import java.util.Collections;
import java.util.List;

import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@TestInstance(PER_CLASS)
class V1FilmControllerTest {

    private static final String API_PATH = "api/v1/films";
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private MockMvc mockMvc;
    private FilmRepository repository;


    @BeforeAll
    void beforeAll() {
        mockMvc = MockMvcBuilders.standaloneSetup(new V1FilmController(repository))
                .alwaysDo(print())
                .build();
    }

    @Test
    void testGetFilms() throws Exception {
        // given
        given(repository.findAll()).willReturn(filmListWithOneElement());
        // when
        mockMvc.perform(get(API_PATH))
                // then
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[*]", hasSize(1)));
    }

    private List<Film> filmListWithOneElement() {
        return singletonList(Film.builder().build());
    }
}