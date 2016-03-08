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
import io.kongcode.uitests.core.SerializableSeleniumCommand;
import io.kongcode.uitests.core.command.BasicSeleniumCommandFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by jperondini on 07/03/2016.
 */
@Component class TestCaseRepositoryJdbc implements TestCaseRepository {

    public static final String TEST_CASE_INSERT = "INSERT INTO TEST_CASE VALUES (NULL, ?)";
    private static final String INSERT_TEST_CASE_COMMAND =
        "INSERT INTO TEST_CASE_COMMAND VALUES (?, ?, ?, ?)";
    private static final String FIND_TEST_CASE_BY_ID =
        "SELECT ID, NAME FROM TEST_CASE WHERE ID = ?";
    private static final String FIND_TEST_CASE_COMMAND_DATA_BY_TEST_CASE_ID =
        "SELECT TYPE, DATA FROM TEST_CASE_COMMAND WHERE TEST_CASE_ID = ? ORDER BY INDEX";

    private final JdbcTemplate jdbcTemplate;

    TestCaseRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override public Integer insert(TestCase testCase) {
        final KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> createInsertTestCasePreparedStatement(testCase, con), keyHolder);
        final int testCaseId = keyHolder.getKey().intValue();
        insertCommands(testCaseId, testCase.commands);
        return testCaseId;
    }

    @Override public TestCase find(Integer id) {
        TestCase.TestCaseBuilder builder = jdbcTemplate
            .queryForObject(FIND_TEST_CASE_BY_ID, this.createTestCaseBuilderRowMapper(), id);
        findTestCaseCommands(id).forEach(builder::command);
        return builder.build();
    }

    private PreparedStatement createInsertTestCasePreparedStatement(TestCase testCase,
        Connection con) throws SQLException {
        final PreparedStatement preparedStatement =
            con.prepareStatement(TEST_CASE_INSERT, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, testCase.name);
        return preparedStatement;
    }

    private void insertCommands(Integer testCaseId, Iterable<Command> commands) {
        final int[] index = {1};
        commands.forEach(command -> jdbcTemplate
            .update(INSERT_TEST_CASE_COMMAND, testCaseId, index[0]++,
                ((BasicCommand) command).getType().name(),
                ((SerializableSeleniumCommand) command).serialize()));
    }

    private RowMapper<TestCase.TestCaseBuilder> createTestCaseBuilderRowMapper() {
        return (rs, rowNum) -> {
            TestCase.TestCaseBuilder tmp = TestCase.builder();
            int i = 1;
            tmp.withId(rs.getInt(i++)).withName(rs.getString(i++));
            return tmp;
        };
    }

    private List<Command> findTestCaseCommands(Integer id) {
        return jdbcTemplate.query(FIND_TEST_CASE_COMMAND_DATA_BY_TEST_CASE_ID, (rs, rowNum) -> {
            int i = 1;
            return BasicSeleniumCommandFactory
                .createFromSerializedCommand(BasicCommandType.valueOf(rs.getString(i++)),
                    rs.getString(i++));
        }, id);
    }
}
