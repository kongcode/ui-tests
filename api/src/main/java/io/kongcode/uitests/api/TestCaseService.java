package io.kongcode.uitests.api;

import io.kongcode.uitests.api.dto.TestCaseSearchResult;

/**
 * TestCase Services.
 */
public interface TestCaseService {

    /**
     * Creates a new Test case.
     *
     * @param builder Test case builder.
     * @return Test case created.
     */
    TestCase create(TestCase.TestCaseBuilder builder);

    /**
     * Gets all the test cases.
     *
     * @return All the test cases.
     */
    Iterable<TestCaseSearchResult> findAll();
}
