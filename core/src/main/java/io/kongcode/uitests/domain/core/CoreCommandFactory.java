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

package io.kongcode.uitests.domain.core;

import io.kongcode.uitests.api.Command;

/**
 * Created by jperondini on 02/03/2016.
 */
public class CoreCommandFactory {

    public static Command createNavigate(String url) {
        return new NavigateCommand(url);
    }

    public static Command createClick(String selector) {
        return new ClickCommand(selector);
    }

    public static Command createCheckText(String selector, String text) {
        return new CheckTextCommand(selector, text);
    }

    public static Command createFillText(String selector, String text) {
        return new FillTextCommand(selector, text);
    }

    public static Command createSelectOption(String selectSelector, String optionText) {
        return new SelectOptionCommand(selectSelector, optionText);
    }

    public static Command createSelectRadio(String radioSelector, String value) {
        return new SelectRadioCommand(radioSelector, value);
    }


    public static Command createSelectCheckbox(String selector) {
        return new SelectCheckboxCommand(selector);
    }
}
