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

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by jperondini on 08/03/2016.
 */
@Configuration @EnableAutoConfiguration public class TestCaseITestConfiguration {
    @Bean public TestCaseSearchService testCaseSearchService(JdbcTemplate jdbcTemplate) {
        return new TestCaseSearchServiceJdbc(jdbcTemplate);
    }

    @Bean public TestCaseRepository testCaseRepository(JdbcTemplate jdbcTemplate) {
        return new TestCaseRepositoryJdbc(jdbcTemplate);
    }
}
