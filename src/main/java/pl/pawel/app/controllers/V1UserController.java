package pl.pawel.app.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pawel.app.domain.AccountRepository;
import pl.pawel.app.domain.UserRepository;
import pl.pawel.app.domain.models.Account;
import pl.pawel.app.domain.models.User;

import java.util.LinkedList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.notFound;

@RequestMapping(V1UserController.API_PATH)
@RequiredArgsConstructor
@RestController
@Tag(name = V1UserController.API_PATH)
public class V1UserController {

    static final String API_PATH = "/api/v1/user";

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    @Operation(summary = "Get User")
    @GetMapping(path = "/{corporateId}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(String corporateId) {
        return userRepository.findByCorporateId(corporateId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> notFound().build());
    }

    @Operation(summary = "Create dummy accounts")
    @GetMapping(path = "/add", produces = APPLICATION_JSON_VALUE)
    public List<Account> createAccount() {
        List<Account> accounts = new LinkedList<>();
        for (int i = 1; i <= 10; i++) {
            Account account = Account.builder()
                    .name("Name" + i)
                    .surname("surname" + i)
                    .corporateId(String.valueOf(i))
                    .build();
            accounts.add(account);
        }
        accounts.forEach(a -> {
            a.attach(accountRepository);
            a.add();
        });
        return accounts;
    }
}
