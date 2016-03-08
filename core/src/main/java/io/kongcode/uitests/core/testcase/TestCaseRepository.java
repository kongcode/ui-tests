package io.kongcode.uitests.core.testcase;

import io.kongcode.uitests.api.TestCase;

/**
 * Created by joao on 05/03/16.
 */
interface TestCaseRepository {
    Integer insert(TestCase testCase);

    TestCase find(Integer id);
}
