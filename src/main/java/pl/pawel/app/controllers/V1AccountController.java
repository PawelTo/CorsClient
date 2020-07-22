package pl.pawel.app.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pawel.app.domain.AccountRepository;
import pl.pawel.app.domain.models.Account;

import java.util.List;

@RequestMapping(V1AccountController.API_PATH)
@RequiredArgsConstructor
@RestController
@Tag(name = V1AccountController.API_PATH)
public class V1AccountController {

    static final String API_PATH = "/api/v1/accounts";

    private final AccountRepository repository;

    @GetMapping()
    @Operation(summary = "Get Accounts")
    public List<Account> findAll(){
        return repository.findAll();
    }
}
