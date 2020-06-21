package pl.pawel.app.junit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
public class EnableIfDockerApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    private static final String DATABASE_DRIVER_CLASS_NAME = "org.testcontainers.jdbc.ContainerDatabaseDriver";
    private static final String DATABASE_NAME = "dbName";
    private static final String DATABASE_SCHEMA = "public";
    private static final String DATABASE_USERNAME = "userName";
    private static final String DATABASE_VERSION = "11-alpine";

    //TODO find dependency for JdbcDatabaseContainer class
    //private final JdbcDatabaseContainer DATABASE_CONTAINER = new PostgreSQLContainer().withDatabaseName(DATABASE_NAME).withUsername(DATABASE_USERNAME);

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        configureDataSource(applicationContext);
    }

    private void configureDataSource(ConfigurableApplicationContext applicationContext) {
        log.info("Applying data source properties");
        TestPropertyValues.of("spring.datasource.driver-class-name=" + DATABASE_DRIVER_CLASS_NAME,
                "spring.datasource.url=" + jdbcUrl(),
                //"spring.datasource.username="+DATABASE_CONTAINER.getUsername(),
                "spring.liquibase.default-schema=" + DATABASE_SCHEMA)
                .applyTo(applicationContext.getEnvironment());
    }

    private String jdbcUrl() {
        return "jdbc:tc:postgresql:" + DATABASE_VERSION + ":///" + DATABASE_NAME;
    }
}
