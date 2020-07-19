package pl.pawel.app.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pawel.app.domain.models.User;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(V1UserController.API_PAHT)
@RequiredArgsConstructor
@RestController
@Tag(name = V1UserController.API_PAHT)
public class V1UserController {

    static final String API_PAHT = "/api/v1/user";

    @Operation(summary = "Add film by invoke analysis creation")
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public User getUser(){
        return new User();
    }
}
