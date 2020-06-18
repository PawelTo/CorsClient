package pl.pawel.app.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.pawel.app.domain.models.Actor;
import pl.pawel.app.persistence.mappers.ActorMapper;
import pl.pawel.app.persistence.repositories.ActorEntityRepository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ActorPersistenceImpl implements ActorPersistence{

    private final ActorEntityRepository repository;
    private final ActorMapper mapper;

    @Override
    public Long add(Actor actor) {
        return repository.save(mapper.mapToPersistence(actor)).getId();
    }

    @Override
    public List<Actor> findAll() {
        return mapper.mapToDomain(repository.findAll());
    }
}
