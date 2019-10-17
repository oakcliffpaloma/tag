package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.improving.tag.items.Item;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class AttackCommand extends BaseAliasedCommand {
    private final InputOutput io;


    private AttackCommand(InputOutput io, InputOutput io1) {
        super(io, "attack", "a", "at", "att", "atk");
        this.io = io;
    }

    @Override
    public boolean isValid(String input, Game game) {
        if (input == null) return false;
        return input.trim().equalsIgnoreCase("attack");
    }

    @Override
    public void execute(String input, Game game) {
        var adversary = game.getPlayer().getLocation().getAdversary();

        if (adversary == null) {
            io.displayText("attack what?!");
            return;
        } else {
            Random random = new Random();
            int Random = random.nextInt(100);
            Random += 1;
            if (Random <= 20) {
                var damage = adversary.getDamageTaken();
                adversary.setDamageTaken(adversary.getDamageTaken() + 10);
                adversary.setHitPoints(adversary.getHitPoints() - 10);
                io.displayText(adversary.getName() + " remaining points are " + adversary.getHitPoints());
            } else {
                io.displayText("You Missed!");
            }
        }

            var advLoot = adversary.getDropItem();
            if (adversary.getHitPoints() <= 0) {
                io.displayText(adversary.getName() + " has been defeated! You acquired " + advLoot);
                game.getPlayer().getInventory().addItem(advLoot);
                game.getPlayer().getLocation().setAdversary(null);
            }
        }
    }

