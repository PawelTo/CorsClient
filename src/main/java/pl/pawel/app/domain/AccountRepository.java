package pl.pawel.app.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.pawel.app.domain.models.Account;
import pl.pawel.app.persistence.AccountPersistence;

@Component
@RequiredArgsConstructor
public class AccountRepository {

    @Getter
    private final AccountPersistence persistence;

    public Account findByCorporateId(String corporateId){
        return persistence.findByCorporateId(corporateId);
    }
}
