package pl.pawel.app.domain.cinema;


import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class CinemaItemTest {

    @Test
    void testGetMethodWhenFilmWatched(){
        // given
        CinemaItem item = CinemaItem.builder()
                .operation(CinemaItem.Operation.Set)
                .build();
        // then
        assertThat(item.getMethod(), equalTo(CinemaItem.Method.FILM_WATCHED));
    }
}