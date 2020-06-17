package pl.pawel.app.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pawel.app.persistence.entity.FilmEntity;

public interface FilmEntityRepository extends JpaRepository<FilmEntity, Long> {
}
