package io.kongcode.uitests.domain;

import io.kongcode.uitests.api.Command;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jperondini on 02/03/2016.
 */
public final class TestCase {

    public final Integer id;
    public final String name;
    private final List<Command> commands;

    private TestCase(Integer id, String name, List<Command> commands) {
        this.id = id;
        this.name = name;
        this.commands = commands;
    }

    public void run() {
        commands.forEach(Command::execute);
    }

    public static TestCaseBuilder builder() {
        return new TestCaseBuilder();
    }

    public static class TestCaseBuilder {
        private Integer id;
        private String name;
        private List<Command> commands = new ArrayList<>();

        public TestCaseBuilder withId(Integer id) {
            this.id = id;
            return this;
        }

        public TestCaseBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public TestCase build() {
            return new TestCase(id, name, commands);
        }

        public TestCaseBuilder command(Command command) {
            this.commands.add(command);
            return this;
        }
    }
}
