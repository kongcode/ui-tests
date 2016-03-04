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

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by jperondini on 03/03/2016.
 */
class SelectOptionCommand implements CoreCommand {
    public final String selectSelector;
    public final String optionValue;

    public SelectOptionCommand(String selectSelector, String optionValue) {
        this.selectSelector = selectSelector;
        this.optionValue = optionValue;
    }

    @Override public CoreCommandType getType() {
        return CoreCommandType.SELECT_OPTION;
    }

    @Override public void execute() {
        $(selectSelector).selectOptionByValue(optionValue);
    }
}
