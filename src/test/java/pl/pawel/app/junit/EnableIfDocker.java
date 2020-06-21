package pl.pawel.app.junit;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ExtendWith(EnableIfDockerCondition.class)
@ExtendWith(TestNameLoggingCallback.class)
@ContextConfiguration(initializers = {EnableIfDockerApplicationContextInitializer.class})
public @interface EnableIfDocker {
}
