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

/**
 * Created by jperondini on 02/03/2016.
 */
public class BasicSeleniumCommandFactory {

    public static Command createNavigate(String url) {
        return new NavigateSeleniumCommand(url);
    }

    public static Command createClick(String selector) {
        return new ClickSeleniumCommand(selector);
    }

    public static Command createCheckText(String selector, String text) {
        return new CheckTextSeleniumCommand(selector, text);
    }

    public static Command createFillText(String selector, String text) {
        return new FillTextSeleniumCommand(selector, text);
    }

    public static Command createSelectOption(String selectSelector, String optionText) {
        return new SelectOptionSeleniumCommand(selectSelector, optionText);
    }

    public static Command createSelectRadio(String radioSelector, String value) {
        return new SelectRadioSeleniumCommand(radioSelector, value);
    }


    public static Command createSelectCheckbox(String selector) {
        return new SelectCheckboxSeleniumCommand(selector);
    }

    public static Command createFromSerializedCommand(BasicCommandType type, String data) {
        final Gson gson = new Gson();
        Command command;
        switch (type) {
            case CHECK_TEXT:
                command = gson.fromJson(data, CheckTextSeleniumCommand.class);
                break;
            case CLICK:
                command = gson.fromJson(data, ClickSeleniumCommand.class);
                break;
            case FILL_FIELD:
                command = gson.fromJson(data, FillTextSeleniumCommand.class);
                break;
            default:
                throw new UnsupportedOperationException("Invalid command type");
        }
        return command;
    }
}
