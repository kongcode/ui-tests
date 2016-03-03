package io.kongcode.uitests.domain.core;

import static com.codeborne.selenide.Selenide.open;

/**
 * Created by jperondini on 02/03/2016.
 */
class NavigateCommand implements CoreCommand {

    public final String url;

    NavigateCommand(String url) {
        this.url = url;
    }

    @Override public void execute() {
        open(url);
    }

    @Override public CoreCommandType getType() {
        return CoreCommandType.NAVIGATE;
    }
}
