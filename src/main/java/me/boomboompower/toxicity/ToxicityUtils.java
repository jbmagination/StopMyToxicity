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

public class ToxicityUtils {

    public static boolean containsToxicWord(String message) {
        boolean isToxic = false;

        message = new ChatComponentText(message).getUnformattedText();

        for (String s : ToxicityMain.toxicWords) {
            if (ToxicityMain.containsIgnoreCase(message, s)) {
                isToxic = true;
            }
        }

        return isToxic;
    }

    public static void sendMessage(String message) {
        Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.RED + "S" + EnumChatFormatting.DARK_RED + "T" + EnumChatFormatting.DARK_GRAY + " > " + EnumChatFormatting.GRAY + message));
    }
}
