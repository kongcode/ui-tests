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
import io.kongcode.uitests.api.basic.BasicCommand;
import io.kongcode.uitests.api.basic.BasicCommandType;
import io.kongcode.uitests.core.SerializableSeleniumCommand;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by jperondini on 03/03/2016.
 */
class SelectOptionSeleniumCommand implements BasicCommand, SerializableSeleniumCommand {
    public final String selectSelector;
    public final String optionValue;

    public SelectOptionSeleniumCommand(String selectSelector, String optionValue) {
        this.selectSelector = selectSelector;
        this.optionValue = optionValue;
    }

    @Override public BasicCommandType getType() {
        return BasicCommandType.SELECT_OPTION;
    }

    @Override public void execute() {
        $(selectSelector).selectOptionByValue(optionValue);
    }

    @Override public String serialize() {
        return new Gson().toJson(this);
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        SelectOptionSeleniumCommand that = (SelectOptionSeleniumCommand) o;
        return Objects.equals(selectSelector, that.selectSelector) && Objects
            .equals(optionValue, that.optionValue);
    }

    @Override public int hashCode() {
        return Objects.hash(selectSelector, optionValue);
    }
}
