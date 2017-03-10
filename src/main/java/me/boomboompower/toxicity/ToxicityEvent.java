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

import me.boomboompower.toxicity.events.ClientChatEvent;
import me.boomboompower.toxicity.gui.CustomChatGUI;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.lang.reflect.Field;

public class ToxicityEvent {

    public ToxicityEvent() {
    }

    @SubscribeEvent(priority = EventPriority.HIGH)
    public void onChatSend(ClientChatEvent event) {
        if (!event.getMessage().isEmpty()) {
            if (ToxicityUtils.containsToxicWord(event.getMessage())) {
                ToxicityUtils.sendMessage("Your message contained a " + EnumChatFormatting.RED + "blacklisted" + EnumChatFormatting.GRAY + " word!");
                event.setCanceled(true);
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGH)
    public void onGuiOpen(GuiOpenEvent event) {
        if (ToxicityMain.getInstance().enabled) {
            if (event.gui instanceof GuiChat) {
                event.gui = new CustomChatGUI(from((GuiChat) event.gui));
            }
        }
    }

    private String from(GuiChat previous) {
        String s = "";
        try {
            Field f = previous.getClass().getDeclaredFields()[8];

            f.setAccessible(true);

            s = String.valueOf(f.get(previous));
        } catch (Exception ex) { ex.printStackTrace(); }
        return s;
    }
}
