/*
 *     Copyright (C) 2016 boomboompower
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

package me.boomboompower.toxicity.utils;

import me.boomboompower.toxicity.ToxicityMain;

import java.util.Arrays;

public class Words {

    public Words() {
    }

    public void add() {
        add("gay", "g@y", "fag", "f@g", "faggot", "faggit");
        add("kys", "kill yourself", "die", "d1e", "d!e", "drown");
        add("dick", "d1ck", "dic", "dik", "dix", "penis", "pen1s", "pussy", "pu$$y", "vagina");
        add("get good", "retard", "no skill", "idiot", "1diot", "b@d", "bad");
        add("fuck", "fuc", "fuq", "fuk", "cum", "bitch", "b1tch", "bich", "b1ch");
    }

    private void add(String... words) {
        Arrays.stream(words).forEach(word -> ToxicityMain.toxicWords.add(new Word(word)));
    }
}
