package pl.pawel.app.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pawel.app.persistence.entity.ActorEntity;

import java.util.List;
import java.util.Optional;

public interface ActorEntityRepository extends JpaRepository<ActorEntity, Long> {
    Optional<ActorEntity> findByNameAndSurname(String name, String surname);
}
