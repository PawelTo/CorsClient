package pl.pawel.app.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pawel.app.persistence.entity.AccountEntity;

public interface AccountEntityRepository extends JpaRepository<AccountEntity, Long> {

    AccountEntity findByCorporateId(String corporateId);
}
