package pl.pawel.app.persistence;

import pl.pawel.app.domain.models.Actor;

import java.util.List;

public interface ActorPersistence {

    Long add(Actor actor);

    List<Actor> findAll();
}
