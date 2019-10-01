package org.improving.tag.commands;

import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

@Component
public class SearchCommand extends BaseEmoteCommand {
    private InputOutput io;

    public SearchCommand(InputOutput io) {
        super("You found a treasure", io, "search", "srch");
    }
}
