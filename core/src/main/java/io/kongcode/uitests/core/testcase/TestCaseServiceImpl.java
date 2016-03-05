package io.kongcode.uitests.core.testcase;

import io.kongcode.uitests.api.TestCase;
import io.kongcode.uitests.api.TestCaseService;
import io.kongcode.uitests.api.dto.TestCaseSearchResult;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

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

    @Override public Stream<TestCaseSearchResult> findAll() {
        return repository.streamAll().map(TestCaseSearchResult::new);
    }
}
