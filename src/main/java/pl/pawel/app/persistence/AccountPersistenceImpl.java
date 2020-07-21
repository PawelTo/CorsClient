package pl.pawel.app.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.pawel.app.domain.models.Account;
import pl.pawel.app.persistence.mappers.AccountMapper;
import pl.pawel.app.persistence.repositories.AccountEntityRepository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AccountPersistenceImpl implements AccountPersistence {

    private final AccountEntityRepository repository;
    private final AccountMapper mapper;

    @Override
    public Long add(Account account) {
        return save(account);
    }

    @Override
    public List<Account> findByCorporateId(String corporateId) {
        return mapper.mapToDomain(repository.findByCorporateId(corporateId));
    }

    private Long save(Account account) {
        return repository.save(mapper.mapToPersistence(account))
                .getId();
    }
}
