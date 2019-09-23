package org.improving.tag.commands;

import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

@Component
public class ThrowCommand extends BaseEmoteCommand {
    public ThrowCommand(InputOutput io) {
        super("throw", "You threw it far", io );
    }
}
