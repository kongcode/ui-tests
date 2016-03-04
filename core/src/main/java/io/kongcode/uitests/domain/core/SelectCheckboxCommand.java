package io.kongcode.uitests.domain.core;

import io.kongcode.uitests.api.CoreCommand;
import io.kongcode.uitests.api.CoreCommandType;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by joao on 04/03/16.
 */
class SelectCheckboxCommand implements CoreCommand {

    public final String selector;

    SelectCheckboxCommand(String selector) {
        this.selector = selector;
    }

    @Override public CoreCommandType getType() {
        return CoreCommandType.SELECT_CHECKBOX;
    }

    @Override public void execute() {
        $(selector).click();
    }
}
