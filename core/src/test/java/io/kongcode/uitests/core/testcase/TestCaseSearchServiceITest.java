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

package io.kongcode.uitests.core.testcase;

import io.kongcode.uitests.api.TestCase;
import io.kongcode.uitests.api.dto.TestCaseSearchResult;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.jdbc.JdbcTestUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * Created by jperondini on 08/03/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(TestCaseITestConfiguration.class)
public class TestCaseSearchServiceITest {

    @Autowired private TestCaseRepository repository;

    @Autowired private TestCaseSearchService searchService;

    @Autowired private JdbcTemplate jdbcTemplate;

    @Before public void setUp() throws Exception {
        JdbcTestUtils.deleteFromTables(jdbcTemplate, "TEST_CASE_COMMAND", "TEST_CASE");
    }

    @Test public void testFindAll() throws Exception {
        TestCase.TestCaseBuilder builder = TestCase.builder();
        List<TestCase> testCaseList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            TestCase test = builder.withName("name" + i).build();
            Integer id = repository.insert(test);
            testCaseList.add(builder.withId(id).build());
        }
        List<TestCaseSearchResult> expected =
            testCaseList.stream().map(TestCaseSearchResult::new).collect(Collectors.toList());
        assertEquals(expected, searchService.findAll());
    }
}
