package pl.pawel.app.junit;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

@Slf4j
public class TestNameLoggingCallback implements BeforeTestExecutionCallback {

    @Override
    public void beforeTestExecution(ExtensionContext extensionContext) throws Exception {
        log.info("Executing test method: {}", extensionContext.getTestMethod().get().toString());
    }
}
