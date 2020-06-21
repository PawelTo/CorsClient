package pl.pawel.app.persistence.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.pawel.app.domain.models.Actor;
import pl.pawel.app.persistence.entity.ActorEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ActorMapper {

    @Mapping(target = "repository", ignore = true)
    Actor mapToDomain(ActorEntity actorEntity);

    List<Actor> mapToDomain(List<ActorEntity> actors);

    @Mapping(target = "createdTimestamp", ignore = true)
    @Mapping(target = "updatedTimestamp", ignore = true)
    ActorEntity mapToPersistence(Actor actor);
}
