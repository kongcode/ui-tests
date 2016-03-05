package io.kongcode.uitests.api;

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
}
