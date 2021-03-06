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

import com.codeborne.selenide.Condition;
import com.google.gson.Gson;
import io.kongcode.uitests.api.basic.BasicCommand;
import io.kongcode.uitests.api.basic.BasicCommandType;
import io.kongcode.uitests.core.SerializableSeleniumCommand;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by jperondini on 03/03/2016.
 */
class CheckTextSeleniumCommand implements BasicCommand, SerializableSeleniumCommand {
    public final String selector;
    public final String text;

    CheckTextSeleniumCommand(String selector, String text) {
        this.selector = selector;
        this.text = text;
    }

    @Override public BasicCommandType getType() {
        return BasicCommandType.CHECK_TEXT;
    }

    @Override public void execute() {
        $(selector).shouldHave(Condition.text(text));
    }

    @Override public String serialize() {
        return new Gson().toJson(this);
    }

    @Override public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o, false);
    }

    @Override public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, false);
    }
}
