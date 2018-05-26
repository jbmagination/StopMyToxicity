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

package me.boomboompower.toxicity;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

import java.util.regex.Pattern;

public class ToxicityUtils {

    public static boolean containsToxicWord(final String message) {
        if (ToxicityMain.getInstance().ignoreCommands && message.toCharArray()[0] == '/') return false;
        if (message.equalsIgnoreCase("L")) return true;

        final boolean[] isToxic = {false};

        ToxicityMain.toxicWords.forEach(word -> {
            if (containsIgnoreCase(message, word.getWord())) {
                isToxic[0] = true;
            }
        });
        return isToxic[0];
    }

    public static String colorize(String textToTranslate) {
        char[] b = textToTranslate.toCharArray();
        for (int i = 0; i < b.length - 1; i++) {
            if (b[i] == '&' && "0123456789AaBbCcDdEeFfKkLlMmNnOoRr".indexOf(b[i+1]) > -1) {
                b[i] = '\u00A7';
                b[i+1] = Character.toLowerCase(b[i+1]);
            }
        }
        return new String(b);
    }

    public static boolean containsIgnoreCase(String message, String contains) {
        return Pattern.compile(Pattern.quote(contains), Pattern.CASE_INSENSITIVE).matcher(message).find();
    }

    public static void sendMessage(String message) {
        Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.RED + "S" + EnumChatFormatting.DARK_RED + "T" + EnumChatFormatting.DARK_GRAY + " > " + EnumChatFormatting.GRAY + message));
    }
}
