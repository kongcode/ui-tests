package io.kongcode.uitests.core.testcase;

import io.kongcode.uitests.api.TestCase;
import io.kongcode.uitests.api.TestCaseService;
import org.springframework.stereotype.Service;

/**
 * {@link io.kongcode.uitests.api.TestCaseService} Implementation
 */
@Service class TestCaseServiceImpl implements TestCaseService {

    private final TestCaseRepository repository;

    TestCaseServiceImpl(TestCaseRepository repository) {
        this.repository = repository;
    }

    @Override public TestCase create(TestCase.TestCaseBuilder builder) {
        return repository.save(builder.build());
    }
}
