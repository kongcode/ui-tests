package io.kongcode.uitests.core.command;

import com.google.gson.Gson;
import io.kongcode.uitests.api.Command;
import io.kongcode.uitests.api.basic.BasicCommandType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by joao on 04/03/16.
 */
public class SelectCheckboxSeleniumCommandTest {

    @Test public void testFactory() throws Exception {
        String selector = "selector";
        SelectCheckboxSeleniumCommand command =
            (SelectCheckboxSeleniumCommand) BasicSeleniumCommandFactory
                .createSelectCheckbox(selector);
        assertEquals(selector, command.selector);
        assertEquals(BasicCommandType.SELECT_CHECKBOX, command.getType());
    }

    @Test public void testSerialize() throws Exception {
        String selector = "selector";
        SelectCheckboxSeleniumCommand command =
            (SelectCheckboxSeleniumCommand) BasicSeleniumCommandFactory
                .createSelectCheckbox(selector);
        assertEquals(new Gson().toJson(command), command.serialize());
    }

    @Test public void testParse() throws Exception {
        String selector = "selector";
        Command command = BasicSeleniumCommandFactory.createSelectCheckbox(selector);
        Command fromSerializedCommand = BasicSeleniumCommandFactory
            .createFromSerializedCommand(BasicCommandType.SELECT_CHECKBOX,
                new Gson().toJson(command));
        assertEquals(command, fromSerializedCommand);
    }
}
