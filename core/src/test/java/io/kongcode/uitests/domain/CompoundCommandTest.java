package io.kongcode.uitests.domain;

import io.kongcode.uitests.api.Command;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by jperondini on 02/03/2016.
 */
public class CompoundCommandTest {

    @Test public void testExecute() throws Exception {
        final Holder holder = new Holder();
        Integer id = 1;
        String name = "Test";
        CompoundCommand compoundCommand =
            CompoundCommand.builder().withId(id).withName(name).command(() -> holder.value = true)
                .build();
        compoundCommand.execute();
        assertEquals(id, compoundCommand.id);
        assertEquals(name, compoundCommand.name);
        assertTrue(holder.value);
    }

    private static class Holder {
        private boolean value = false;
    }
}
