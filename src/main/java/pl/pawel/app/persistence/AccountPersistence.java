package pl.pawel.app.persistence;

import pl.pawel.app.domain.models.Account;

public interface AccountPersistence {

    Account findByCorporateId(String corporateId);
}
