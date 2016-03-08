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

import io.kongcode.uitests.api.Command;
import io.kongcode.uitests.api.TestCase;
import io.kongcode.uitests.api.basic.BasicCommand;
import io.kongcode.uitests.api.basic.BasicCommandType;
import io.kongcode.uitests.core.command.BasicSeleniumCommandFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by jperondini on 07/03/2016.
 */
@Configuration @EnableAutoConfiguration @RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(TestCaseRepositoryITest.class)
public class TestCaseRepositoryITest {

    @Autowired private TestCaseRepository repository;

    @Test public void testInsert() throws Exception {
        final String name = "Test";
        final String selector = "selector";
        final String text = "text";
        final String url = "url";
        final String value = "value";
        List<Command> commands = Arrays
            .asList(BasicSeleniumCommandFactory.createCheckText(selector, text),
                BasicSeleniumCommandFactory.createClick(selector),
                BasicSeleniumCommandFactory.createFillText(selector, text),
                BasicSeleniumCommandFactory.createNavigate(url),
                BasicSeleniumCommandFactory.createSelectCheckbox(selector),
                BasicSeleniumCommandFactory.createSelectOption(selector, text),
                BasicSeleniumCommandFactory.createSelectRadio(selector, value));
        TestCase.TestCaseBuilder builder = TestCase.builder().withName(name);
        commands.forEach(builder::command);

        Integer actualId = repository.insert(builder.build());

        TestCase testCase = repository.find(actualId);

        assertEquals(actualId, testCase.id);
        assertEquals(name, testCase.name);

        for (int i = 0; i < testCase.commands.size(); i++) {
            BasicCommand command = (BasicCommand) testCase.commands.get(i);
            BasicCommandType[] types = BasicCommandType.values();
            assertEquals(types[i], command.getType());
        }
    }

    @Bean public TestCaseRepository testCaseRepository(JdbcTemplate jdbcTemplate) {
        return new TestCaseRepositoryJdbc(jdbcTemplate);
    }
}

