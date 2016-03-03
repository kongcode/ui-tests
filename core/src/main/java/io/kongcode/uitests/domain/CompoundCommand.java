package io.kongcode.uitests.domain;

import io.kongcode.uitests.api.Command;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jperondini on 02/03/2016.
 */
public final class CompoundCommand implements Command {

    public final Integer id;
    public final String name;
    private final List<Command> commands;

    private CompoundCommand(Integer id, String name, List<Command> commands) {
        this.id = id;
        this.name = name;
        this.commands = commands;
    }

    @Override public void execute() {
        commands.forEach(Command::execute);
    }

    public static CompoundCommandBuilder builder() {
        return new CompoundCommandBuilder();
    }

    public static class CompoundCommandBuilder {
        private Integer id;
        private String name;
        private List<Command> commands = new ArrayList<>();

        private CompoundCommandBuilder() {
        }

        public CompoundCommandBuilder withId(Integer id) {
            this.id = id;
            return this;
        }

        public CompoundCommandBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public CompoundCommandBuilder command(Command command) {
            this.commands.add(command);
            return this;
        }

        public CompoundCommand build() {
            return new CompoundCommand(id, name, commands);
        }
    }
}
