package pl.pawel.app.persistence;

import pl.pawel.app.domain.models.Account;

import java.util.List;

public interface AccountPersistence {

    Long add(Account account);

    List<Account> findByCorporateId(String corporateId);
}
