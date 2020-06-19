package pl.pawel.app.domain.models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.pawel.app.domain.FilmRepository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class FilmTest {

    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    private FilmRepository repository;

    private Film film;

    @BeforeEach
    void beforeEach() {
        film = Film.builder().build();
    }

    @Test
    void testAdd() {
        // given
        given(repository.getPersistence().add(film)).willReturn(10001L);
        film.attach(repository);
        // when
        film.add();
        // then
        assertThat(film.getId(), greaterThan(0L));
    }

    @Test
    void testAttach() {
        // when
        film.attach(repository);
        // then
        assertThat(film.isAttached(), equalTo(true));
    }

    @Test
    void testActorAdd() {
        // given
        film.attach(repository);
        Actor actor = Actor.builder().build();
        // when
        film.actorAdd(actor);
        // then
        assertThat(film.getActors().contains(actor), equalTo(true));
    }
}