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

package io.kongcode.uitests.domain.core;

import com.codeborne.selenide.SelenideElement;
import org.junit.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by jperondini on 03/03/2016.
 */
public class SelectRadioCommandITest {

    @Test public void testExecute() throws Exception {
        String url =
            "file:" + new File("src/test/resources/command-itest/SelectRadioCommandITest.html")
                .getAbsolutePath();
        String selector = ".rdo";

        open(url);
        $$(selector).forEach(selenideElement -> selenideElement.shouldNotBe(selected));

        for (int i = 1; i < 5; i++) {
            String radioValue = String.valueOf(i);
            CoreCommandFactory.createSelectRadio(selector, radioValue).execute();
            SelenideElement radioOpt = $$(selector).filterBy(value(radioValue)).first();
            assertTrue(radioOpt.exists());
            //radioOpt.shouldHave(attribute("checked", "true"));
            radioOpt.shouldBe(selected);
            assertEquals(3, $$(selector).exclude(selected).size());
        }
    }
}
