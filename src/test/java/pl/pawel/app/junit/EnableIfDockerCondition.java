package pl.pawel.app.junit;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.platform.commons.util.AnnotationUtils;

import java.io.IOException;
import java.lang.reflect.AnnotatedElement;
import java.util.Optional;

@Slf4j
public class EnableIfDockerCondition implements ExecutionCondition {

    private static final String COMMAND = "docker info";
    private static final ConditionEvaluationResult DISABLED = ConditionEvaluationResult.disabled("Docker is not available");
    private static final ConditionEvaluationResult ENABLED = ConditionEvaluationResult.enabled("Docker is available");
    private static final ConditionEvaluationResult ENABLED_ANNOTATION_NOT_PRESENT =
            ConditionEvaluationResult.enabled("@EnableIfDocker annotation is not present");

    private static boolean docker = false;

    static {
        try {
            docker = isDocker();
        } catch (Exception ex) {
            log.info("docker command execution failure: {}", ex.getMessage());
        }
    }

    @Override
    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext extensionContext) {
        if (annotationIsNotPresent(extensionContext)) {
            return ENABLED_ANNOTATION_NOT_PRESENT;
        }
        if (docker) {
            return ENABLED;
        }
        return DISABLED;
    }

    private boolean annotationIsNotPresent(ExtensionContext extensionContext) {
        Optional<AnnotatedElement> element = extensionContext.getElement();
        return AnnotationUtils.findAnnotation(element, EnableIfDocker.class).isPresent();
    }

    private static boolean isDocker() throws IOException, InterruptedException {
        return Runtime.getRuntime().exec(COMMAND).waitFor() == 0;
    }
}
