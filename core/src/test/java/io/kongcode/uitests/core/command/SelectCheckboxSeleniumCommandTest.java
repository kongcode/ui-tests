package io.kongcode.uitests.core.command;

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
            (SelectCheckboxSeleniumCommand) BasicSeleniumCommandFactory.createSelectCheckbox(selector);
        assertEquals(selector, command.selector);
        assertEquals (BasicCommandType.SELECT_CHECKBOX, command.getType());
    }
}
