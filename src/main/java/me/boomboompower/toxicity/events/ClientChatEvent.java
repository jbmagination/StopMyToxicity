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

package me.boomboompower.toxicity.events;

import com.google.common.base.Strings;
import net.minecraftforge.fml.common.eventhandler.Cancelable;
import net.minecraftforge.fml.common.eventhandler.Event;

@Cancelable
public class ClientChatEvent extends Event {

    private String message;
    private final String originalMessage;

    public ClientChatEvent(String message) {
        this.setMessage(message);
        this.originalMessage = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String newMessage) {
        this.message = Strings.emptyToNull(newMessage);
    }

    public String getOriginalMessage() {
        return originalMessage;
    }
}
