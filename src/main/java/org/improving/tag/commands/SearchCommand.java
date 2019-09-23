package org.improving.tag.commands;

import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

@Component
public class SearchCommand extends BaseEmoteCommand {
    public SearchCommand(InputOutput io) {
        super("search", "You found a treasure", io);
    }
}
