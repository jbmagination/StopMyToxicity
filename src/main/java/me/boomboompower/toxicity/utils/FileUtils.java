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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileUtils {

   public FileUtils() {
   }

   public static void getVars() throws Throwable {
       try {
           File e = new File(ToxicityMain.USER_DIR);
           if (!e.exists()) {
               e.mkdirs();
           }

           boolean executeWriter = false;

           if (exists(ToxicityMain.USER_DIR + "toxicwords.txt")) {
               BufferedReader f = new BufferedReader(new FileReader(ToxicityMain.USER_DIR + "toxicwords.txt"));

               List<String> lines = f.lines().collect(Collectors.toList());
               if (lines.size() > 0) {
                   for (String s : lines) {
                       ToxicityMain.toxicWords.add(String.valueOf(s));
                   }
               } else {
                   executeWriter = true;
               }
           } else {
               executeWriter = true;
           }

           if (executeWriter) {
               Writer.execute();
           }
       } catch (Throwable ignored) {
           throw ignored;
       }
   }

    private static boolean exists(String path) {
        return Files.exists(Paths.get(path));
    }
}
