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

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.stream.Stream;

/**
 * Created by jperondini on 07/03/2016.
 */
@Component class TestCaseRepositoryJdbc implements TestCaseRepository {

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
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement preparedStatement =
                con.prepareStatement("INSERT INTO TEST_CASE VALUES (NULL, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, testCase.name);
            return preparedStatement;
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }
}
