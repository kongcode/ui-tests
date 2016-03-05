package io.kongcode.uitests.api.dto;

import io.kongcode.uitests.api.TestCase;

import java.util.Objects;

/**
 * Created by joao on 05/03/16.
 */
public class TestCaseSearchResult {

    public final Integer id;
    public final String name;

    public TestCaseSearchResult(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public TestCaseSearchResult(TestCase testCase) {
        this(testCase.id, testCase.name);
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        TestCaseSearchResult that = (TestCaseSearchResult) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override public int hashCode() {
        return Objects.hash(id, name);
    }
}
