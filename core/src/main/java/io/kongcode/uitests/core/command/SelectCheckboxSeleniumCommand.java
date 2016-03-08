package io.kongcode.uitests.core.command;

import com.google.gson.Gson;
import io.kongcode.uitests.api.basic.BasicCommand;
import io.kongcode.uitests.api.basic.BasicCommandType;
import io.kongcode.uitests.core.SerializableSeleniumCommand;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by joao on 04/03/16.
 */
class SelectCheckboxSeleniumCommand implements BasicCommand, SerializableSeleniumCommand {

    public final String selector;

    SelectCheckboxSeleniumCommand(String selector) {
        this.selector = selector;
    }

    @Override public BasicCommandType getType() {
        return BasicCommandType.SELECT_CHECKBOX;
    }

    @Override public void execute() {
        $(selector).click();
    }

    @Override public String serialize() {
        return new Gson().toJson(this);
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        SelectCheckboxSeleniumCommand that = (SelectCheckboxSeleniumCommand) o;
        return Objects.equals(selector, that.selector);
    }

    @Override public int hashCode() {
        return Objects.hash(selector);
    }
}
