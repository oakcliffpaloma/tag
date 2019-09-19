package org.improving.tag;

import org.improving.tag.commands.*;

import java.util.Date;
import java.util.Scanner;

public class Game {
    private Date startTime;
    private Date endTime;
    private BaseEmoteCommand[] commands;

    public Game() {
        commands = new BaseEmoteCommand[]{
                new LookCommand(),
                new DanceCommand(),
                new InventoryCommand(),
                new JumpCommand()};
    }
    
    public Date getStartTime() {
        return startTime;
    }

    private void setStartTime(Date val) {
        startTime = val;
    }

    public Date getEndTime() {
        return endTime;
    }

    private void setEndTime(Date endTime) {
        this.endTime = endTime;
    }


    public void run() {
        Scanner scanner = new Scanner(System.in);
        this.setStartTime(new Date());


        boolean loop = true;
        while (loop) {
            System.out.print("> ");
            String input = scanner.nextLine();
            input = input.trim();
            BaseEmoteCommand validCommand = getValidCommand(input);
            if (null != validCommand) {
                validCommand.execute(input);
            } else if (input.equalsIgnoreCase("exit")) {
                    System.out.println("Goodbye.");
                    loop = false;
                } else {
                    System.out.println("Huh? I don't understand.");
                }
            }
            this.setEndTime(new Date());
        }

    private BaseEmoteCommand getValidCommand(String input) {
        for (BaseEmoteCommand command : commands) {
            if (command.isValid(input)) {
                return command;
            }
        }
        return null;
    }
}
