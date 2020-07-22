package pl.pawel.app.domain.cinema;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@ExtendWith(MockitoExtension.class)
class CinemaPostProcessingTest {

    @Test
    void testGetOverallStatusWhenItemStatusesIsNull(){
        // given
        CinemaPostProcessing postProcessing = CinemaPostProcessing.builder().build();
        // then
        assertThat(postProcessing.getOverallStatus(), is(CinemaPostProcessing.Status.success));
    }
}