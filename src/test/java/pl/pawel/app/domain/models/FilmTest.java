package pl.pawel.app.domain.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.pawel.app.domain.FilmRepository;

@ExtendWith(MockitoExtension.class)
class FilmTest {

    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    private FilmRepository repository;

    private Film film;

    @BeforeEach
    void beforeEach(){
        film = Film.builder().build();
    }
}