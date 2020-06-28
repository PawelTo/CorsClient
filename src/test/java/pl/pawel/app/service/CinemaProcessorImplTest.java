package pl.pawel.app.service;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.pawel.app.domain.ActorRepository;
import pl.pawel.app.domain.FilmRepository;
import pl.pawel.app.domain.cinema.*;

import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class CinemaProcessorImplTest {

    @Mock
    private ActorRepository actorRepository;

    @Mock
    private FilmRepository filmRepository;

    @InjectMocks
    private CinemaProcessorImpl processor;

    @Test
    void testProcess() {
        // given
        String identityRequestId = "id";
        CinemaProcessing processing = CinemaProcessing.builder()
                .identityRequestId(identityRequestId)
                .build();
        // when
        CinemaPostProcessing postProcessing = processor.process(processing);
        // then
        assertThat(postProcessing.getIdentityRequestId(), is(identityRequestId));
    }

    @Nested
    class testProcessForFilmWatched {

        @Test
        void whenFilmNotFound() {
            // given
            CinemaIdentity identity = mock(CinemaIdentity.class);
            CinemaItem item = mock(CinemaItem.class);
            String itemId = "id";
            given(item.getId()).willReturn(itemId);
            given(item.getMethod()).willReturn(CinemaItem.Method.FILM_WATCHED);
            CinemaProcessing processing = CinemaProcessing.builder()
                    .identity(identity)
                    .items(Collections.singletonList(item))
                    .build();
            // when
            CinemaItemStatus itemStatus = processor.process(processing).getItemStatuses().get(0);
            //then
            assertThat(itemStatus.getId(), is(itemId));
            assertThat(itemStatus.getStatus(), is(CinemaItemStatus.Status.failure));
        }

        @Test
        void whenFilmAlreadyWatched() {
            //TODO implement with during TDD
        }

        @Test
        void whenFilmIsNotWatched() {
            //TODO implement with during TDD
        }
    }

    @Nested
    class testProcessForFilmAdd {

        @Test
        void whenFilmAlreadyAdded(){
            //TODO implement with during TDD, also implement other test cases
        }
    }

    @Nested
    class testProcessForActorAdd{

        @Test
        void whenActorAlreadyAdded(){
            // given
            //TODO implement with during TDD, also implement other test cases
        }
    }
}