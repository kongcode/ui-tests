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

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by jperondini on 03/03/2016.
 */
class SelectRadioSeleniumCommand implements BasicCommand, SerializableSeleniumCommand {
    public final String radioSelector;
    public final String radioValue;

    public SelectRadioSeleniumCommand(String radioSelector, String radioValue) {
        this.radioSelector = radioSelector;
        this.radioValue = radioValue;
    }

    @Override public BasicCommandType getType() {
        return BasicCommandType.SELECT_RADIO;
    }

    @Override public void execute() {
        $$(radioSelector).filterBy(value(radioValue)).first().selectRadio(radioValue);
    }

    @Override public String serialize() {
        return new Gson().toJson(this);
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        SelectRadioSeleniumCommand that = (SelectRadioSeleniumCommand) o;
        return Objects.equals(radioSelector, that.radioSelector) && Objects
            .equals(radioValue, that.radioValue);
    }

    @Override public int hashCode() {
        return Objects.hash(radioSelector, radioValue);
    }
}
