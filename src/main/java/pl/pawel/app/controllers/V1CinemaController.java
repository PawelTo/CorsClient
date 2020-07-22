package pl.pawel.app.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pawel.app.domain.cinema.CinemaPostProcessing;
import pl.pawel.app.domain.cinema.CinemaProcessing;
import pl.pawel.app.service.CinemaProcessor;

@RequestMapping(V1CinemaController.API_PAHT)
@RequiredArgsConstructor
@RestController
@Tag(name = V1CinemaController.API_PAHT)
public class V1CinemaController {

    static final String API_PAHT = "/api/v1/cinema";

    private final CinemaProcessor cinemaProcessor;

    @Operation(summary = "Add film by invoke analysis creation")
    @PostMapping(path = "/process")
    public CinemaPostProcessing cinemaProcess(CinemaProcessing cinemaProcessing){
        return cinemaProcessor.process(cinemaProcessing);
    }
}
