package io.kongcode.uitests.core.command;

import com.google.gson.Gson;
import io.kongcode.uitests.api.basic.BasicCommand;
import io.kongcode.uitests.api.basic.BasicCommandType;
import io.kongcode.uitests.core.SerializableSeleniumCommand;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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
        return EqualsBuilder.reflectionEquals(this, o, false);
    }

    @Override public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, false);
    }
}
