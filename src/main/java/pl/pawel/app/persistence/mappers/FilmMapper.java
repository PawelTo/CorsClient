package pl.pawel.app.persistence.mappers;

import org.mapstruct.Mapper;
import pl.pawel.app.domain.models.Film;
import pl.pawel.app.persistence.entity.FilmEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FilmMapper {

    Film mapToDomain(FilmEntity filmEntity);

    List<Film> mapToDomain(List<FilmEntity> all);

    FilmEntity mapToPersistence(Film film);
}
