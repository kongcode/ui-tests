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

import io.kongcode.uitests.api.CoreCommand;
import io.kongcode.uitests.api.CoreCommandType;

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
