package org.improving.tag.commands;

import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

@Component
public class TeleportCommand extends BaseEmoteCommand{
    private InputOutput io;

    public TeleportCommand(InputOutput io) {
        super( "You phase out of existence", io, "teleport", "port", "tele");
    }
}
