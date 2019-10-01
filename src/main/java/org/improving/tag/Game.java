package org.improving.tag;

import org.improving.tag.commands.*;
import org.improving.tag.items.UniqueItems;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

@Component
public class Game {
    private Date startTime;
    private Date endTime;
    private Command[] commands;
    private InputOutput io;
    private Player p;
    private Location startingLocation;
    private List<Location> locationList = new ArrayList<>();
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

    public Player getPlayer() {
        return p;
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
        this.setStartTime(new Date());

        boolean loop = true;
        while (loop) {
            try {
                io.displayPrompt("> ");
                String input = io.receiveInput();

                Command validCommand = getValidCommand(input);
                if (null != validCommand) {
                    validCommand.execute(input, this);
                } else {
                    io.displayText("Huh? I don't understand.");
                }
            } catch (GameExitException ex) {
                loop = false;
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
        this.locationList.add(tdh);

        var td = new Location();
        td.setName("The Desert");
        this.locationList.add(td);


        var ta = new Location();
        ta.setName("The Amazon");
        this.locationList.add(ta);


        var tmcs = new Location();
        tmcs.setName("The Mac & Cheese Shop");
        tmcs.setTreasureChest(new TreasureChest(UniqueItems.THE_ONE_RING, "A Kraft Box"));
        this.locationList.add(tmcs);

        var tvm = new Location();
        tvm.setName("The Velvet Moose");
        this.locationList.add(tvm);


        var air = new Location();
        air.setName("Airport");
        this.locationList.add(air);


        var ict = new Location();
        ict.setName("The Ice Cream Truck");
        this.locationList.add(ict);


        var tm = new Location();
        tm.setName("The Mountains");
        this.locationList.add(tm);


        var tr = new Location();
        tr.setName("The Reef");
        this.locationList.add(tr);


        var mall = new Location();
        mall.setName("The Mall");
        this.locationList.add(mall);


        var mtd = new Location();
        mtd.setName("Mount Doom");
        this.locationList.add(mtd);
        mtd.setAdversary(new Adversary("Sauron"));


        var vod = new Location();
        vod.setName("The Volcano of Death");
        this.locationList.add(vod);


        tdh.getExits().add(new Exit("Heaven Ave", tmcs, "h", "heaven", "ave", "Heaven Ave"));
        tdh.getExits().add(new Exit("The Deathly Brownie", td, "tdb", "brownie", "Deathly", "the", "The Deathly Brownie"));
        td.getExits().add(new Exit("Rocky Road", ict, "rr", "rocky", "road", "rd", "r", "Rocky Road"));
        td.getExits().add(new Exit("Camel Path", ta, "cp", "camel", "path", "Camel Path"));
        td.getExits().add(new Exit("The Docks", air, "td", "d", "docks", "dock"));
        tmcs.getExits().add(new Exit("Highway 121", ta, "121", "hwy", "hwy 121", "h121", "Highway 121"));
        tmcs.getExits().add(new Exit("Paradise Rd", tr, "paradise", "pd", "Paradise Rd"));
        tmcs.getExits().add(new Exit("Highway 21", vod, "h21", "21", "Highway 21"));
        tr.getExits().add(new Exit("The Reef", tvm, "scenic", "sr", "scenic route", "The Reef"));
        tr.getExits().add(new Exit("The City Walk", mall, "city", "city walk", "cw", "walk", "The City Walk"));
        tm.getExits().add(new Exit("Path to Doom", mtd, "path", "doom", "Path to Doom"));
        tm.getExits().add(new Exit("An Escalator of Doom", vod, "escalator", "ed", "An Escalator of Doom"));
        tvm.getExits().add(new Exit("The Front Door", ta, "door", "front", "df", "The Front Door"));
        tvm.getExits().add(new Exit("The Pudding Slide", air, "slide", "pudding", "ps", "tps", "The Pudding Slide"));
        mtd.getExits().add(new Exit("Jump Into Lava", vod, "jump", "lava", "jl", "Jump Into Lava"));
        mtd.getExits().add(new Exit("The Cab", mall, "cab", "tc", "c", "The Cab"));
        ta.getExits().add(new Exit("Amaz-ing Moose", tvm, "amazing", "am", "moose", "zing", "am", "Amaz-ing Moose"));
        air.getExits().add(new Exit("Flight 121", tm, "f121", "121", "Flight 121"));
        air.getExits().add(new Exit("Flight to the Mall", mall, "flight", "mall", "fm", "Flight to the Mall"));
        ict.getExits().add(new Exit("Magic Portal", mtd, "magic", "portal", "mp", "Magic Portal"));
        tm.getExits().add(new Exit("The Plane", ta, "plane", "tp", "p", "The Plane"));
        tm.getExits().add(new Exit("The Narrow Trail", mtd, "narrow", "tnt", "n", "The Narrow Trail"));
        tm.getExits().add(new Exit("The Lava Flow", vod, "lava", "lava flow", "flow", "tlf", "The Lava Flow"));
        tm.getExits().add(new Exit("Bike Trail", tr, "bike", "bt", "b", "Bike Trail"));

        return tdh;
    }


    public Location getLocationOf(String intendedLocationName) {
        for (Location location : locationList) {
            if (intendedLocationName.equalsIgnoreCase(location.getName())) {
                return location;
            }
        }
        return null;
    }
}
