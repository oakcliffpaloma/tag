package org.improving.tag.commands;

import org.improving.tag.Exit;
import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class AttackCommand implements Command{
   private InputOutput io;

    private AttackCommand(InputOutput io)
    { this.io = io;
    }

    @Override
    public boolean isValid(String input, Game game) {
        if (input == null) return false;
        return input.trim().equalsIgnoreCase("attack");
    }

    @Override
    public void execute(String input, Game game) {
        var adversary = game.getPlayer().getLocation().getAdversary();
        var damage = adversary.getDamageTaken();

        if (adversary == null) {
            io.displayText("attack what?!");
        } else
            {    Random random  = new Random();
            int Random  = random.nextInt(100);
            Random += 1;
            if (Random <=20) {
                adversary.setDamageTaken(adversary.getDamageTaken() + 10);
                adversary.setHitPoints(adversary.getHitPoints() - 10);
                io.displayText("Your remaining points are " + adversary.getHitPoints());

            }else {
                io.displayText("You Missed!");
            }
        }
    }

}
