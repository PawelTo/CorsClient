package pl.pawel.app.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.pawel.app.domain.models.Actor;
import pl.pawel.app.persistence.ActorPersistence;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class ActorRepository {

    @Getter
    private ActorPersistence persistence;

    public List<Actor> findAll() {
        return persistence.findAll();
    }
}
