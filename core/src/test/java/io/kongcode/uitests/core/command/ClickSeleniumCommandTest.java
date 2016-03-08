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
import io.kongcode.uitests.api.basic.BasicCommandType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jperondini on 03/03/2016.
 */
public class ClickSeleniumCommandTest {

    @Test public void testFactory() throws Exception {
        String selector = "selector";
        ClickSeleniumCommand command =
            (ClickSeleniumCommand) BasicSeleniumCommandFactory.createClick(selector);
        assertEquals(selector, command.selector);
        assertEquals(BasicCommandType.CLICK, command.getType());
    }

    @Test public void testSerialize() throws Exception {
        String selector = "selector";
        ClickSeleniumCommand command =
            (ClickSeleniumCommand) BasicSeleniumCommandFactory.createClick(selector);
        assertEquals(new Gson().toJson(command), command.serialize());
    }
}
