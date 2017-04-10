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

package me.boomboompower.toxicity.gui;

import me.boomboompower.toxicity.ToxicityMain;

import me.boomboompower.toxicity.enums.ToggleType;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.awt.*;

public class ToxicityGui extends GuiScreen {

    //        - 94
    //        - 70
    //        - 46
    //        - 22
    //        + 2
    //        + 26
    //        + 50
    //        + 74

    public void initGui() {
        this.buttonList.add(new GuiButton(0, this.width / 2 - 75, this.height / 2 - 22, 150, 20, "Enabled: " + (ToxicityMain.getInstance().enabled ? EnumChatFormatting.GREEN + "Enabled" : EnumChatFormatting.RED + "Disabled")));
        this.buttonList.add(new GuiButton(1, this.width / 2 - 75, this.height / 2 + 2, 150, 20, "Ignore commands: " + (ToxicityMain.getInstance().ignoreCommands ? EnumChatFormatting.GREEN + "Enabled" : EnumChatFormatting.RED + "Disabled")));
    }

    public void display() {
        FMLCommonHandler.instance().bus().register(this);
    }

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event) {
        FMLCommonHandler.instance().bus().unregister(this);
        Minecraft.getMinecraft().displayGuiScreen(this);
    }

    public void drawScreen(int x, int y, float ticks) {
        super.drawDefaultBackground();
        drawCenteredString(this.fontRendererObj, "Toxicity", this.width / 2, this.height / 2 - 94, Color.WHITE.getRGB());
        super.drawScreen(x, y, ticks);
    }

    protected void keyTyped(char c, int key) {
        if (key == 1) {
            mc.displayGuiScreen(null);
        }
    }

    public void updateScreen() {
        super.updateScreen();
    }

    protected void actionPerformed(GuiButton button) {
        switch (button.id) {
            case 0:
                ToxicityMain.getInstance().toggle(ToggleType.ENABLED);
                this.buttonList.get(0).displayString = "Enabled: " + (ToxicityMain.getInstance().enabled ? EnumChatFormatting.GREEN + "Enabled" : EnumChatFormatting.RED + "Disabled");
                break;
            case 1:
                ToxicityMain.getInstance().toggle(ToggleType.IGNORE_COMMANDS);
                this.buttonList.get(1).displayString = "Ignore commands: " + (ToxicityMain.getInstance().ignoreCommands ? EnumChatFormatting.GREEN + "Enabled" : EnumChatFormatting.RED + "Disabled");
                break;
        }
    }

    public void onGuiClosed() {
    }

    public boolean doesGuiPauseGame() {
        return false;
    }

}