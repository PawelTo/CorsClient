package pl.pawel.app.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.pawel.app.domain.models.Account;
import pl.pawel.app.persistence.mappers.AccountMapper;
import pl.pawel.app.persistence.repositories.AccountEntityRepository;

@Repository
@RequiredArgsConstructor
public class AccountPersistenceImpl implements AccountPersistence {

    private final AccountEntityRepository repository;
    private final AccountMapper mapper;

    @Override
    public Account findByCorporateId(String corporateId) {
        return mapper.mapToDomain(repository.findByCorporateId(corporateId));
    }
}
