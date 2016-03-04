package io.kongcode.uitests.domain.core;

import io.kongcode.uitests.api.basic.BasicCommandType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by joao on 04/03/16.
 */
public class SelectChecboxCommandTest {

    @Test public void testFactory() throws Exception {
        String selector = "selector";
        SelectCheckboxCommand command =
            (SelectCheckboxCommand) CoreCommandFactory.createSelectCheckbox(selector);
        assertEquals(selector, command.selector);
        assertEquals (BasicCommandType.SELECT_CHECKBOX, command.getType());
    }
}
