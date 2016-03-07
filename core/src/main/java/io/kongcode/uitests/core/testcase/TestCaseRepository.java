package io.kongcode.uitests.core.testcase;

import io.kongcode.uitests.api.TestCase;

import java.util.stream.Stream;

/**
 * Created by joao on 05/03/16.
 */
interface TestCaseRepository {
    Stream<TestCase> streamAll();

    Integer insert(TestCase testCase);
}
