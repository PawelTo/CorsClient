package pl.pawel.app.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.pawel.app.domain.models.Film;
import pl.pawel.app.persistence.mappers.FilmMapper;
import pl.pawel.app.persistence.repositories.FilmEntityRepository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FilmPersistenceImpl implements FilmPersistence{

    private final FilmEntityRepository repository;
    private final FilmMapper mapper;

    @Override
    public Long add(Film film) {
        return save(film);
    }

    @Override
    public List<Film> findAll() {
        return mapper.mapToDomain(repository.findAll());
    }

    private Long save(Film film) {
        return repository.save(mapper.mapToPersistence(film)).getId();
    }
}
