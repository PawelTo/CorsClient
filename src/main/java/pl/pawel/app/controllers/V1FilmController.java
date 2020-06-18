package pl.pawel.app.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pawel.app.domain.FilmRepository;
import pl.pawel.app.domain.models.Film;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(V1FilmController.API_PAHT)
@RequiredArgsConstructor
@RestController
@Tag(name = V1FilmController.API_PAHT)
public class V1FilmController {

    static final String API_PAHT = "v1/api/films";

    private final FilmRepository filmRepository;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @Operation(summary = "Fetch all films")
    public List<Film> getFilms() {
        return filmRepository.findAll();
    }

    @GetMapping(path = "/producers", produces = APPLICATION_JSON_VALUE)
    @Operation(summary = "Fetch films producers")
    public List<String> getProducers() {
        return filmRepository.findAllProducers();
    }
}
