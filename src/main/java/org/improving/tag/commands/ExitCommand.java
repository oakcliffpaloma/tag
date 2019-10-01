package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.GameExitException;
import org.improving.tag.InputOutput;
import org.improving.tag.SaveGameFactory;
import org.springframework.stereotype.Component;


@Component
public class ExitCommand extends BaseAliasedCommand {
    private final SaveGameFactory saveFactory;
    private final InputOutput io;


    public ExitCommand(InputOutput io, SaveGameFactory saveFactory) {
        super(io,  "exit", "out", "e");
        this.saveFactory = saveFactory;
        this.io = io;
    }

    @Override
    public void childExecute(String input, Game game) {
        saveFactory.save(game);
        io.displayText("Goodbye.");
        throw new GameExitException();
    }
}