package pl.pawel.app.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Repository;
import pl.pawel.app.domain.models.Film;
import pl.pawel.app.persistence.mappers.FilmMapper;
import pl.pawel.app.persistence.repositories.FilmEntityRepository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FilmPersistenceImpl implements FilmPersistence {

    private final FilmEntityRepository repository;
    private final FilmMapper mapper;

    @CacheEvict("films-all")
    @Override
    public Long add(Film film) {
        return save(film);
    }

    @Cacheable("films-all")
    @Override
    public List<Film> findAll() {
        return mapper.mapToDomain(repository.findAll());
    }

    @CacheEvict(value = "films-all", allEntries = true)
    public void update(Film film) {
        save(film);
    }

    private Long save(Film film) {
        return repository.save(mapper.mapToPersistence(film)).getId();
    }
}
