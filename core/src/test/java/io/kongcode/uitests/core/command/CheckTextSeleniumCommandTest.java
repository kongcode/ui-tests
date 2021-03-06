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

package io.kongcode.uitests.core.command;

import com.google.gson.Gson;
import io.kongcode.uitests.api.Command;
import io.kongcode.uitests.api.basic.BasicCommandType;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by jperondini on 03/03/2016.
 */
public class CheckTextSeleniumCommandTest {

    @Test public void testFactory() throws Exception {
        String selector = "selector";
        String text = "text";
        CheckTextSeleniumCommand command =
            (CheckTextSeleniumCommand) BasicSeleniumCommandFactory.createCheckText(selector, text);
        assertEquals(selector, command.selector);
        assertEquals(text, command.text);
        assertEquals(BasicCommandType.CHECK_TEXT, command.getType());
    }

    @Test public void testSerialization() throws Exception {
        String selector = "selector";
        String text = "text";
        CheckTextSeleniumCommand command =
            (CheckTextSeleniumCommand) BasicSeleniumCommandFactory.createCheckText(selector, text);
        assertEquals(new Gson().toJson(command), command.serialize());
    }

    @Test public void testParse() throws Exception {
        String selector = "selector";
        String text = "text";
        Command command = BasicSeleniumCommandFactory.createCheckText(selector, text);
        Command fromSerializedCommand = BasicSeleniumCommandFactory
            .createFromSerializedCommand(BasicCommandType.CHECK_TEXT, new Gson().toJson(command));
        assertEquals(command, fromSerializedCommand);
    }
}
