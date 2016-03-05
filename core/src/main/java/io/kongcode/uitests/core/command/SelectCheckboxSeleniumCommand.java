package io.kongcode.uitests.core.command;

import io.kongcode.uitests.api.basic.BasicCommand;
import io.kongcode.uitests.api.basic.BasicCommandType;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by joao on 04/03/16.
 */
class SelectCheckboxSeleniumCommand implements BasicCommand {

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
}
