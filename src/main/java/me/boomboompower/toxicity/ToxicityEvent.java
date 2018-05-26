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

import me.boomboompower.toxicity.gui.CustomChatGUI;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import org.lwjgl.input.Keyboard;

public class ToxicityEvent {

    Minecraft mc;

    public ToxicityEvent() {
        mc = Minecraft.getMinecraft();
    }

    @SubscribeEvent
    public void onInventoryOpen(GuiOpenEvent event) {
        if (ToxicityMain.getInstance().enabled) {
            if (event.gui instanceof GuiChat) {
                boolean useSlash = Keyboard.isKeyDown(Keyboard.KEY_SLASH);
                event.gui = new CustomChatGUI(useSlash ? "/" : "");
            }
        }
    }
}
