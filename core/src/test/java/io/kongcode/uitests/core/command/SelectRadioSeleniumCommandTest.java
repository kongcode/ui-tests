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

import io.kongcode.uitests.api.basic.BasicCommandType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jperondini on 03/03/2016.
 */
public class SelectRadioSeleniumCommandTest {

    @Test public void testFactory() throws Exception {
        String radioSelector = "radioSelector";
        String value = "radioValue";
        SelectRadioSeleniumCommand command =
            (SelectRadioSeleniumCommand) BasicSeleniumCommandFactory.createSelectRadio(radioSelector, value);
        assertEquals(radioSelector, command.radioSelector);
        assertEquals(value, command.radioValue);
        assertEquals(BasicCommandType.SELECT_RADIO, command.getType());
    }
}
