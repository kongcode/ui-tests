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

import io.kongcode.uitests.api.dto.TestCaseSearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by jperondini on 08/03/2016.
 */
class TestCaseSearchServiceJdbc implements TestCaseSearchService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired TestCaseSearchServiceJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override public Iterable<TestCaseSearchResult> findAll() {
        return jdbcTemplate.query("SELECT ID, NAME FROM TEST_CASE", (rs, rowNum) -> {
            int i = 1;
            return new TestCaseSearchResult(rs.getInt(i++), rs.getString(i++));
        });
    }
}
