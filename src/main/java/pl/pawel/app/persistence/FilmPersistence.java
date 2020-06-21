package pl.pawel.app.persistence;

import pl.pawel.app.domain.models.Film;

import java.util.List;

public interface FilmPersistence {

    Long add(Film film);

    List<Film> findAll();

    void update(Film film);
}
