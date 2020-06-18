package pl.pawel.app.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pawel.app.persistence.entity.ActorEntity;

public interface ActorEntityRepository extends JpaRepository<ActorEntity, Long> {
}
