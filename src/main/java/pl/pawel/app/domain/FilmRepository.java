package pl.pawel.app.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.pawel.app.domain.models.Film;
import pl.pawel.app.persistence.FilmPersistence;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Component
@RequiredArgsConstructor
@Slf4j
public class FilmRepository {

    @Getter
    private final FilmPersistence persistence;

    public List<Film> findAll(){
        return persistence.findAll()
                .stream()
                .map(film -> film.attach(this))
                .collect(toList());
    }

    public List<String> findAllProducers(){
        return findAll().stream()
                .map(Film::getProducer)
                .collect(toList());
    }

    public Optional<Film> findById(String filmId) {
        return persistence.findById(Long.valueOf(filmId))
                .map(film -> film.attach(this));
    }
}
