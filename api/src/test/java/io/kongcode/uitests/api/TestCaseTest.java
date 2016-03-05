/*
 * Copyright (C) 2016  KongCode
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package io.kongcode.uitests.api;

import io.kongcode.uitests.api.TestCase;
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
