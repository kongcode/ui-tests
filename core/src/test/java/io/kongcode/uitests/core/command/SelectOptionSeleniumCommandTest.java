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
public class SelectOptionSeleniumCommandTest {

    @Test public void testFactory() throws Exception {
        String selectSelector = "selectSelector";
        String optionValue = "optionValue";
        SelectOptionSeleniumCommand selectOptionCommand =
            (SelectOptionSeleniumCommand) BasicSeleniumCommandFactory
                .createSelectOption(selectSelector, optionValue);
        assertEquals(selectSelector, selectOptionCommand.selectSelector);
        assertEquals(optionValue, selectOptionCommand.optionValue);
        assertEquals(BasicCommandType.SELECT_OPTION, selectOptionCommand.getType());
    }

    @Test public void testSerialize() throws Exception {
        String selectSelector = "selectSelector";
        String optionValue = "optionValue";
        SelectOptionSeleniumCommand selectOptionCommand =
            (SelectOptionSeleniumCommand) BasicSeleniumCommandFactory
                .createSelectOption(selectSelector, optionValue);
        assertEquals(new Gson().toJson(selectOptionCommand), selectOptionCommand.serialize());
    }
}
