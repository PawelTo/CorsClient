package pl.pawel.app.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(V1FilmsController.API_PAHT)
@RestController
public class V1FilmsController {

    static final String API_PAHT = "v1/api/films";

    @GetMapping
    public String getFilms(){
        return "film";
    }
}
