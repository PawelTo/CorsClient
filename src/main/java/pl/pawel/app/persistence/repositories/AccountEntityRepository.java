package pl.pawel.app.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pawel.app.persistence.entity.AccountEntity;

import java.util.List;

public interface AccountEntityRepository extends JpaRepository<AccountEntity, Long> {

    List<AccountEntity> findByCorporateId(String corporateId);
}
