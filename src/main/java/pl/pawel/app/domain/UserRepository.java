package pl.pawel.app.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pawel.app.domain.models.Account;
import pl.pawel.app.domain.models.User;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserRepository {

    private final AccountRepository accountRepository;

    public Optional<User> findByCorporateId(String corporateId){
        Account account = accountRepository.findByCorporateId(corporateId);
        return null;
    }
}
