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

import java.io.FileWriter;
import java.io.IOException;

public class Writer implements Runnable {

    private static String ls = System.lineSeparator();

    public Writer() {
    }

    public static void execute() {
        (new Thread(new Writer())).start();
    }

    public void run() {
        try {
            FileWriter e = new FileWriter(ToxicityMain.USER_DIR + "toxicwords.txt");

            write(e, "L");
            write(e, "gay");
            write(e, "die");
            write(e, "kys");
            write(e, "fuck");
            write(e, "idiot");
            write(e, "r bad");
            write(e, "bitch");
            write(e, "pussy");
            write(e, "drown");
            write(e, "death");
            write(e, "vagina");
            write(e, "faggot");
            write(e, "retard");
            write(e, "are bad");
            write(e, "get good");
            write(e, "no skill");

            e.close();
        } catch (Throwable var56) {
            var56.printStackTrace();
        }
    }

    private void write(FileWriter writer, String text) {
        try {
            writer.write(text + ls);

            ToxicityMain.toxicWords.add(String.valueOf(text));
        } catch (IOException var4) {
            var4.printStackTrace();
        }
    }
}