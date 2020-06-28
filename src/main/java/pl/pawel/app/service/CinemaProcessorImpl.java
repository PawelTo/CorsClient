package pl.pawel.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pawel.app.domain.ActorRepository;
import pl.pawel.app.domain.FilmRepository;
import pl.pawel.app.domain.cinema.CinemaIdentity;
import pl.pawel.app.domain.cinema.CinemaItem;
import pl.pawel.app.domain.cinema.CinemaItemStatus;
import pl.pawel.app.domain.cinema.CinemaPostProcessing;
import pl.pawel.app.domain.cinema.CinemaProcessing;
import pl.pawel.app.domain.models.Actor;
import pl.pawel.app.domain.models.Film;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;
import static org.springframework.util.CollectionUtils.isEmpty;

@RequiredArgsConstructor
@Service
public class CinemaProcessorImpl implements CinemaProcessor {

    private final ActorRepository actorRepository;
    private final FilmRepository filmRepository;

    @Override
    public CinemaPostProcessing process(CinemaProcessing processing) {
        List<CinemaItemStatus> itemStatusList = processItems(processing.getIdentity(), processing.getItems());
        return null;
    }

    private List<CinemaItemStatus> processItems(CinemaIdentity identity, List<CinemaItem> items) {
        if (!isEmpty(items)) {
            return items.stream()
                    .map(item -> processItem(identity, item))
                    .collect(toList());
        }
        return emptyList();
    }

    private CinemaItemStatus processItem(CinemaIdentity identity, CinemaItem item) {
        CinemaItemStatus cinemaItemStatus = null;
        switch (item.getMethod()) {
            case ACTOR_ADD:
                cinemaItemStatus = handleActorAdd(identity, item);
                break;
                //TODO implement all cases as show above
            /*case ACTOR_REMOVE:
                cinemaItemStatus = handleActorRemove(identity, item);
                break;
            case FILM_ADD:
                cinemaItemStatus = handleFilmAdd(identity, item);
                break;
            case FILM_REMOVE:
                cinemaItemStatus = handleFilmRemove(identity, item);
                break;
            case FILM_WATCHED:
                cinemaItemStatus = handleFilmWatched(identity, item);
                break;
            default:
                cinemaItemStatus = handelUnknown(identity, item);*/
        }
        return cinemaItemStatus;
    }

    private CinemaItemStatus handleActorAdd(CinemaIdentity identity, CinemaItem item) {
        Film film = filmRepository.findById(identity.getFilmId()).orElseGet(() -> addFilmFor(identity));
        Actor actor = actorRepository.findByNameAndSurname(item.getValue().substring(2), item.getName());
        if(film.getActors().contains(actor)){
            return CinemaItemStatus.warning(item.getId(),"Actor already added");
        }
        film.actorAdd(actor);
        return CinemaItemStatus.success(item.getId());
    }

    private Film addFilmFor(CinemaIdentity identity) {
        return buildFilmFrom(identity)
                .attach(filmRepository)
                .add();
    }

    private Film buildFilmFrom(CinemaIdentity identity) {
        return Film.builder()
                .name(identity.getFilmName())
                .build();
    }
}
