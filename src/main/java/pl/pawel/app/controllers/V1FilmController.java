package pl.pawel.app.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.pawel.app.domain.FilmRepository;
import pl.pawel.app.domain.models.Film;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(V1FilmController.API_PATH)
@RequiredArgsConstructor
@RestController
@Tag(name = V1FilmController.API_PATH)
public class V1FilmController {

    static final String API_PATH = "/api/v1/films";

    private final FilmRepository filmRepository;

    @Operation(summary = "Add film by invoke analysis creation")
    @GetMapping(path = "/add", produces = APPLICATION_JSON_VALUE)
    public Film invokeGet() {
        Film film = new Film().toBuilder().producer("producer").name("name").state(Film.State.TO_WATCH).repository(filmRepository).build();
        return film.add();
    }

    @Operation(summary = "Add film")
    @PostMapping(produces = APPLICATION_JSON_VALUE)
    public Film add(@RequestBody Film film) {
        return film.attach(filmRepository)
                .add();
    }

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
