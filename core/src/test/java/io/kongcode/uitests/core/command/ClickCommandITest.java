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

package io.kongcode.uitests.core.command;

import com.codeborne.selenide.Condition;
import io.kongcode.uitests.api.Command;
import org.junit.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by jperondini on 03/03/2016.
 */
public class ClickCommandITest {

    @Test public void testExecute() throws Exception {
        String url = "file:" + new File("src/test/resources/command-itest/ClickCommandITest.html")
            .getAbsolutePath();
        String result1 = "Button1";
        Command command = CoreCommandFactory.createClick("#button1");
        open(url);
        $("#result1").shouldNotHave(Condition.text(result1));
        command.execute();
        $("#result1").shouldHave(Condition.text(result1));
    }
}
