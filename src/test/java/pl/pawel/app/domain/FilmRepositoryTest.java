package pl.pawel.app.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.pawel.app.domain.models.Film;
import pl.pawel.app.persistence.FilmPersistence;

import java.util.Arrays;
import java.util.List;

import static java.util.Collections.singletonList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class FilmRepositoryTest {

    @Mock
    private FilmPersistence persistence;

    private FilmRepository repository;

    @BeforeEach
    void beforeEach() {
        repository = new FilmRepository(persistence);
    }

    @Test
    void testFindAll() {
        // given
        given(persistence.findAll()).willReturn(singletonList(Film.builder().build()));
        // when
        List<Film> films = repository.findAll();
        // then
        assertThat(films, everyItem(hasProperty("attached")));
    }

    @Test
    void testFindAllProducers() {
        // given
        String producer1 = "producer1";
        String producer2 = "producer2";
        given(persistence.findAll()).willReturn(filmsWithProducers(producer1, producer2));
        // when
        List<String> producers = repository.findAllProducers();
        //then
        assertThat(producers.size(), is(2));
        assertThat(producers.get(0), is(producer1));
        assertThat(producers.get(1), is(producer2));
    }

    private List<Film> filmsWithProducers(String producer1, String producer2) {
        Film film1 = Film.builder().producer(producer1).build();
        Film film2 = Film.builder().producer(producer2).build();
        return Arrays.asList(film1, film2);
    }
}