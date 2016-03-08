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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.stream.Stream;

/**
 * Created by jperondini on 07/03/2016.
 */
@Component class TestCaseRepositoryJdbc implements TestCaseRepository {

    public static final String TEST_CASE_INSERT = "INSERT INTO TEST_CASE VALUES (NULL, ?)";
    private static final String INSERT_TEST_CASE_COMMAND =
        "INSERT INTO TEST_CASE_COMMAND VALUES (?, ?, NULL, ?)";

    private final JdbcTemplate jdbcTemplate;

    TestCaseRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override public Stream<TestCase> streamAll() {
        //TODO: Create the correct stream implementation or change the method name to List.
        return jdbcTemplate.query("SELECT ID, NAME FROM TEST_CASE", (rs, rowNum) -> {
            TestCase.TestCaseBuilder builder = TestCase.builder();
            int i = 1;
            builder.withId(rs.getInt(i++)).withName(rs.getString(i++));
            return builder.build();
        }).stream();
    }

    @Override public Integer insert(TestCase testCase) {
        final KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> createInsertTestCasePreparedStatement(testCase, con), keyHolder);
        final int testCaseId = keyHolder.getKey().intValue();
        return testCaseId;
    }

    @Override public TestCase find(Integer id) {
        return jdbcTemplate
            .queryForObject("SELECT ID, NAME FROM TEST_CASE WHERE ID = ?", (rs, rowNum) -> {
                TestCase.TestCaseBuilder builder = TestCase.builder();
                int i = 1;
                builder.withId(rs.getInt(i++)).withName(rs.getString(i++));
                return builder.build();
            }, id);
    }

    private PreparedStatement createInsertTestCasePreparedStatement(TestCase testCase,
        Connection con) throws SQLException {
        final PreparedStatement preparedStatement =
            con.prepareStatement(TEST_CASE_INSERT, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, testCase.name);
        return preparedStatement;
    }
}
