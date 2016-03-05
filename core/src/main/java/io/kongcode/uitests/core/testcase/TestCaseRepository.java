package io.kongcode.uitests.core.testcase;

import io.kongcode.uitests.api.TestCase;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.stream.Stream;

/**
 * Created by joao on 05/03/16.
 */
interface TestCaseRepository extends MongoRepository<TestCase, Integer> {
    Stream<TestCase> streamAll();
}
