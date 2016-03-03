package io.kongcode.uitests.domain.core;

import io.kongcode.uitests.api.Command;

/**
 * Created by jperondini on 02/03/2016.
 */
public class CoreCommandFactory {

    public static Command createNavigate(String url) {
        return new NavigateCommand(url);
    }
}
