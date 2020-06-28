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
import java.util.Optional;

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

    @Caching(evict = {
            @CacheEvict(cacheNames = "films-all", allEntries = true),
            @CacheEvict(cacheNames = "film-by-id", key = "#film.id")
    })
    public void update(Film film) {
        save(film);
    }

    @Cacheable("film-by-id")
    @Override
    public Optional<Film> findById(Long id) {
        return repository.findById(id)
                .map(mapper::mapToDomain);
    }

    private Long save(Film film) {
        return repository.save(mapper.mapToPersistence(film)).getId();
    }
}
