package pl.pawel.app.persistence;

import pl.pawel.app.domain.models.Actor;

import java.util.List;
import java.util.Optional;

public interface ActorPersistence {

    Long add(Actor actor);

    List<Actor> findAll();

    Optional<Actor> findByNameAndSurname(String name, String surname);
}
