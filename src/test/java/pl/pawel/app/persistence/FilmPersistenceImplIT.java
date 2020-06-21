package pl.pawel.app.persistence;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import pl.pawel.app.domain.models.Film;
import pl.pawel.app.junit.EnableIfDocker;
import pl.pawel.app.persistence.mappers.ActorMapper;
import pl.pawel.app.persistence.mappers.ActorMapperImpl;
import pl.pawel.app.persistence.mappers.FilmMapper;
import pl.pawel.app.persistence.mappers.FilmMapperImpl;
import pl.pawel.app.persistence.repositories.FilmEntityRepository;

import javax.sql.DataSource;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;
import static pl.pawel.app.domain.models.Film.State.TO_WATCH;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
//@EnableIfDocker - TODO annotation is switched until it isn't ready
@Slf4j
@TestInstance(PER_CLASS)
class FilmPersistenceImplIT {

    private static final int FILMS_NUMBER = 3;

    @Autowired
    FilmPersistence persistence;

    @TestConfiguration
    static class ITConfiguration {

        @Bean
        public DataSource createTestDataSource() {
            log.info("Create datasource properties");
            return DataSourceBuilder.create()
                    .driverClassName("org.h2.Driver")
                    .url("jdbc:h2:file:D:/Workspaces/File_DB/h2_CorsClient_ForIT")
                    .build();
        }

        @Bean
        public ActorMapper actorMapper() {
            return new ActorMapperImpl();
        }

        @Bean
        public FilmMapper filmMapper() {
            return new FilmMapperImpl();
        }

        @Bean
        public FilmPersistence persistence(FilmMapper mapper, FilmEntityRepository entityRepository) {
            return new FilmPersistenceImpl(entityRepository, mapper);
        }
    }

    @Sql(executionPhase = AFTER_TEST_METHOD, scripts = "classpath:sql/films-truncate")
    @Test
    void testAdd() {
        // given
        Film film = Film.builder()
                .producer("producer")
                .name("name")
                .state(TO_WATCH)
                .build();
        // when
        Long id = persistence.add(film);
        // then
        assertThat(id, greaterThan(0L));
    }

    @Sql("classpath:sql/films-insert")
    @Sql(executionPhase = AFTER_TEST_METHOD, scripts = "classpath:sql/films-truncate")
    @Test
    void testFindAll() {
        // when
        List<Film> films = persistence.findAll();
        // then
        assertThat(films, hasSize(FILMS_NUMBER));
    }
}