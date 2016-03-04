package io.kongcode.uitests.domain.core;

import io.kongcode.uitests.api.basic.BasicCommand;
import io.kongcode.uitests.api.basic.BasicCommandType;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by joao on 04/03/16.
 */
class SelectCheckboxCommand implements BasicCommand {

    public final String selector;

    SelectCheckboxCommand(String selector) {
        this.selector = selector;
    }

    @Override public BasicCommandType getType() {
        return BasicCommandType.SELECT_CHECKBOX;
    }

    @Override public void execute() {
        $(selector).click();
    }
}
