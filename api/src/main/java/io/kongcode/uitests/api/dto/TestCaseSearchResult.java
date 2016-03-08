package io.kongcode.uitests.api.dto;

import io.kongcode.uitests.api.TestCase;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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
        return EqualsBuilder.reflectionEquals(this, o, false);
    }

    @Override public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, false);
    }
}
