package pl.pawel.app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pl.pawel.app.junit.EnableIfDocker;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

//@EnableIfDocker - TODO annotation is switched until it isn't ready
@SpringBootTest(webEnvironment = RANDOM_PORT)
@TestInstance(PER_CLASS)
class ApplicationIT {

    private static final String PATH_API_DOCS = "/v3/api-docs";

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void testApiDocsUrl() {
        // when
        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity(PATH_API_DOCS, String.class);
        // then
        assertThat(responseEntity.getStatusCode(), equalTo(HttpStatus.OK));
    }
}