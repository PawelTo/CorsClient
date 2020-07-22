package pl.pawel.app.persistence;

import pl.pawel.app.domain.models.Film;

import java.util.List;
import java.util.Optional;

public interface FilmPersistence {

    Long add(Film film);

    List<Film> findAll();

    void update(Film film);

    Optional<Film> findById(Long id);
}
