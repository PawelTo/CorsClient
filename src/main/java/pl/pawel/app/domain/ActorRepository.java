package pl.pawel.app.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.pawel.app.domain.models.Actor;
import pl.pawel.app.persistence.ActorPersistence;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class ActorRepository {

    @Getter
    private ActorPersistence persistence;

    public List<Actor> findAll() {
        return persistence.findAll();
    }

    public Optional<Actor> findByNameAndSurname(String name, String surname) {
        return persistence.findByNameAndSurname(name, surname)
                .map(actor -> actor.attach(this));
    }
}
