package pl.pawel.app.persistence.mappers;

import org.mapstruct.Mapper;
import pl.pawel.app.domain.models.Film;
import pl.pawel.app.persistence.entity.FilmEntity;

import java.util.List;

@Mapper(componentModel = "spring", uses = ActorMapper.class)
public interface FilmMapper {

    Film mapToDomain(FilmEntity filmEntity);

    List<Film> mapToDomain(List<FilmEntity> films);

    FilmEntity mapToPersistence(Film film);
}
