package org.improving.tag.commands;

import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

@Component
public class JumpCommand extends BaseEmoteCommand{
    private InputOutput io;

    public JumpCommand(InputOutput io) {
        super( "You jump in the air", io, "jump", "ju", "jmp");
    }
}
