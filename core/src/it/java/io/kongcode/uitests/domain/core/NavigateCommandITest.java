package io.kongcode.uitests.domain.core;

import org.junit.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by joao on 03/03/16.
 */
public class NavigateCommandITest {

    @Test public void testExecute() throws Exception {
        String url =
            "file:" + new File("src/it/resources/NavigateCommandITest.html").getAbsolutePath();
        CoreCommandFactory.createNavigate(url).execute();
        $("#test").shouldHave(text("NavigateCommandITest"));
    }
}
