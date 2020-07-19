package pl.pawel.app.persistence;

import pl.pawel.app.domain.models.Account;

public interface AccountPersistence {

    Long add(Account account);

    Account findByCorporateId(String corporateId);
}
