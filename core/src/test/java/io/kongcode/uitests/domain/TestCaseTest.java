package io.kongcode.uitests.domain;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by jperondini on 02/03/2016.
 */
public class TestCaseTest {

    @Test public void testRun() throws Exception {

        final Holder holder = new Holder();
        Integer id = 1;
        String name = "Test";
        TestCase testCase =
            TestCase.builder().withId(id).withName(name).command(() -> holder.value = true).build();
        testCase.run();
        assertEquals(id, testCase.id);
        assertEquals(name, testCase.name);
        assertTrue(holder.value);
    }

    private static class Holder {
        private boolean value = false;
    }
}
