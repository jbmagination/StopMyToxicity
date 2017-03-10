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

import me.boomboompower.toxicity.utils.FileUtils;

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
import java.util.regex.Pattern;

@Mod(modid = ToxicityMain.MODID, version = ToxicityMain.VERSION, acceptedMinecraftVersions="*")
public class ToxicityMain {

    public static final String MODID = "stopmytoxicity";
    public static final String VERSION = "1.0.1";

    public static String USER_DIR;

    private static ToxicityMain instance;

    public static final ArrayList<String> toxicWords = new ArrayList<String>();
    public boolean enabled = false;

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

        try {
            FileUtils.getVars();
        } catch (Throwable var21) {
            var21.printStackTrace();
        }
    }

    public boolean toggle() {
        return (enabled = !enabled);
    }

    public static boolean containsIgnoreCase(String message, String contains) {
        return Pattern.compile(Pattern.quote(contains), Pattern.CASE_INSENSITIVE).matcher(message).find();
    }

    private void registerCommands(Object... command) {
        try {
            for (Object o : command) {
                ClientCommandHandler.instance.registerCommand((ICommand) o);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static ToxicityMain getInstance() {
        return instance;
    }
}
