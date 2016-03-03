package io.kongcode.uitests.domain.core;

import io.kongcode.uitests.api.Command;

/**
 * Created by joao on 03/03/16.
 */
interface CoreCommand extends Command {

    CoreCommandType getType();
}
