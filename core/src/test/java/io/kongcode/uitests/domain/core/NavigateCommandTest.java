package io.kongcode.uitests.domain.core;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by joao on 03/03/16.
 */
public class NavigateCommandTest {

    @Test public void testFactory() throws Exception {
        String url = "/url";
        NavigateCommand command = (NavigateCommand) CoreCommandFactory.createNavigate(url);
        assertEquals(url, command.url);
    }
}
