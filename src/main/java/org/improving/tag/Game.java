package org.improving.tag;

import org.improving.tag.commands.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Scanner;

@Component
public class Game {
    private Date startTime;
    private Date endTime;
    private Command[] commands;
    private InputOutput io;
    private Player p;
    private Location startingLocation;
    private final SaveGameFactory saveFactory;


    public Game(Command[] commands, InputOutput io, SaveGameFactory saveFactory) {
        startingLocation = buildWorld();
        this.commands = commands;
        this.io = io;
        this.p = new Player(startingLocation);
        this.saveFactory = saveFactory;
    }

    public Location getStartingLocation() {
        return startingLocation;
    }

    public Player getPlayer() { return p; }

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
        this.setStartTime(new Date());

        boolean loop = true;
        while (loop) {
            io.displayPrompt("> ");
            String input = io.receiveInput();

            Command validCommand = getValidCommand(input);
            if (null != validCommand) {
                validCommand.execute(input, this);
            } else if (input.equalsIgnoreCase("exit")) {
                saveFactory.save(this);
                    io.displayText("Goodbye.");
                    loop = false;
                } else {
                    io.displayText("Huh? I don't understand.");
                }
            }
            this.setEndTime(new Date());
        }

    private Command getValidCommand(String input) {
        for (Command command : commands) {
            if (command.isValid(input, this)) {
                return command;
            }
        }
        return null;
    }

    private Location buildWorld() {
        var tdh = new Location();
        tdh.setName("The Deathly Hallows");

        var td = new Location();
                td.setName("The Desert");

        var ta = new Location();
                ta.setName("The Amazon");

        var tmcs = new Location();
        tmcs.setName("The Mac & Cheese Shop");

        var tvm = new Location();
        tvm.setName("The Velvet Moose");

        var air = new Location();
        air.setName("Airport");

        var ict = new Location();
        ict.setName("The Ice Cream Truck");

        var tm = new Location();
        tm.setName("The Mountains");

        var tr = new Location();
        tr.setName("The Reef");

        var mall = new Location();
        mall.setName("The Mall");

        var mtd = new Location();
        mtd.setName("Mount Doom");

        var vod = new Location();
        vod.setName("The Volcano of Death");

        tdh.getExits().add(new Exit("Heaven Ave", tmcs, "h", "heaven", "ave"));
        tdh.getExits().add(new Exit("The Deathly Brownie", td, "tdb", "brownie", "Deathly", "the"));
        td.getExits().add(new Exit("Rocky Road", ict, "rr", "rocky", "road", "rd", "r"));
        td.getExits().add(new Exit("Camel Path", ta, "cp", "camel", "path"));
        td.getExits().add(new Exit("The Docks", air, "td", "d", "docks", "dock"));
        tmcs.getExits().add(new Exit("Highway 121", ta,"121", "hwy", "hwy 121", "h121"));
        tmcs.getExits().add(new Exit("Paradise Rd", tr, "paradise", "pd"));
        tmcs.getExits().add(new Exit("Highway 21", vod, "h21", "21"));
        tr.getExits().add(new Exit("The Reef", tvm, "scenic", "sr", "scenic route"));
        tr.getExits().add(new Exit("The City Walk", mall, "city", "city walk", "cw", "walk"));
        tm.getExits().add(new Exit("Path to Doom", mtd, "path", "doom"));
        tm.getExits().add(new Exit("An Escalator of Doom", vod, "escalator", "ed"));
        tvm.getExits().add(new Exit("The Front Door", ta, "door", "front", "df"));
        tvm.getExits().add(new Exit("The Pudding Slide", air, "slide", "pudding", "ps", "tps"));
        mtd.getExits().add(new Exit("Jump Into Lava", vod, "jump", "lava", "jl"));
        mtd.getExits().add(new Exit("The Cab", mall, "cab", "tc", "c"));
        ta.getExits().add(new Exit("Amaz-ing Moose", tvm, "amazing", "am", "moose", "zing", "am"));
        air.getExits().add(new Exit("Flight 121", tm, "f121", "121"));
        air.getExits().add(new Exit("Flight to the Mall", mall, "flight", "mall", "fm"));
        ict.getExits().add(new Exit("Magic Portal", mtd, "magic", "portal", "mp"));
        tm.getExits().add(new Exit("The Plane", ta, "plane", "tp", "p"));
        tm.getExits().add(new Exit("The Narrow Trail", mtd, "narrow", "tnt", "n"));
        tm.getExits().add(new Exit("The Lava Flow", vod, "lava", "lava flow", "flow", "tlf"));
        tm.getExits().add(new Exit("Bike Trail", tr, "bike", "bt", "b"));

        return tdh;
    }

}
