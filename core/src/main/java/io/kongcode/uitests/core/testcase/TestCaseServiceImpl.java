package io.kongcode.uitests.core.testcase;

import io.kongcode.uitests.api.TestCase;
import io.kongcode.uitests.api.TestCaseService;
import io.kongcode.uitests.api.dto.TestCaseSearchResult;
import org.springframework.stereotype.Service;

/**
 * {@link io.kongcode.uitests.api.TestCaseService} Implementation
 */
@Service class TestCaseServiceImpl implements TestCaseService {

    private final TestCaseRepository repository;
    private final TestCaseSearchService searchService;

    TestCaseServiceImpl(TestCaseRepository repository, TestCaseSearchService searchService) {
        this.repository = repository;
        this.searchService = searchService;
    }

    @Override public TestCase create(TestCase.TestCaseBuilder builder) {
        int id = repository.insert(builder.build());
        return builder.withId(id).build();
    }

    @Override public Iterable<TestCaseSearchResult> findAll() {
        return searchService.findAll();
    }
}
