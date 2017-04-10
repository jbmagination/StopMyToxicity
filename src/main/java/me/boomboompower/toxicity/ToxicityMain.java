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

import me.boomboompower.toxicity.enums.ToggleType;
import me.boomboompower.toxicity.utils.Word;
import me.boomboompower.toxicity.utils.Words;

import net.minecraft.client.Minecraft;
import net.minecraft.command.ICommand;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;
import java.util.ArrayList;

@Mod(modid = ToxicityMain.MODID, version = ToxicityMain.VERSION, acceptedMinecraftVersions="*")
public class ToxicityMain {

    public static final String MODID = "stopmytoxicity";
    public static final String VERSION = "1.0.3";

    public static String USER_DIR;

    private static ToxicityMain instance;

    public static final ArrayList<Word> toxicWords = new ArrayList<Word>();

    public boolean enabled = false;
    public boolean ignoreCommands = false;

    public ToxicityMain() {
        instance = this;
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ModMetadata data = event.getModMetadata();
        data.version = VERSION;
        data.name = EnumChatFormatting.GOLD + "Hypixel " + EnumChatFormatting.GRAY + "-" + EnumChatFormatting.DARK_RED + " #StopToxicity";
        data.authorList.add("boomboompower");
        data.description = "This mod allows you to toggle your chat to prevent you from being able to say toxic things. |" + EnumChatFormatting.RESET + " Made with " + EnumChatFormatting.LIGHT_PURPLE + "<3" + EnumChatFormatting.RESET + " by boomboompower";
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new ToxicityEvent());
        registerCommands(new ToxicityCommand());

        USER_DIR = "stoptoxicity" + File.separator + Minecraft.getMinecraft().getSession().getProfile().getId() + File.separator;
        new Words().add();
    }

    public void toggle(ToggleType type) {
        switch (type) {
            case ENABLED:
                enabled = !enabled;
                break;
            case IGNORE_COMMANDS:
                ignoreCommands = !ignoreCommands;
                break;
            default:

        }
    }

    private void registerCommands(ICommand... command) {
        for (ICommand iCommand : command) {
            try {
                ClientCommandHandler.instance.registerCommand(iCommand);
            } catch (Exception ex) {
                // Shouldn't happen
                ex.printStackTrace();
            }
        }
    }

    public static ToxicityMain getInstance() {
        return instance;
    }
}
