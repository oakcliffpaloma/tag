package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.improving.tag.TreasureChest;
import org.improving.tag.commands.BaseAliasedCommand;
import org.improving.tag.items.Item;
import org.springframework.stereotype.Component;

@Component
public class OpenCommand extends BaseAliasedCommand {

    public OpenCommand(InputOutput io) {
        super(io, "open", "o", "op");
    }

    @Override
    public void childExecute(String input, Game game) {
        Item item = game.getPlayer().getLocation().openTreasureChest();
        io.displayText("You have found: " + item);
        game.getPlayer().getInventory().addItem(item);




        //io.displayText("It is " + item.getDescription());

       /* var location = game.getPlayer().getLocation();
        if (location.getTreasureDescription().equals("")) {
            io.displayText("You found nothing!");
        } else {
            io.displayText("You found: " + location.getTreasureChest().getItem().getDescription());
        }*/

    }
}

