/*
 * Copyright (C) 2016  KongCode
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

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
