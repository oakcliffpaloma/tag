package org.improving.tag;

import java.util.Map;

public class Player {
    private String name = "The Player";
    private int hitpoints = 100;
    private Location location;
    private Inventory inventory = new Inventory();

    public Player(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getHitpoints() {
        return hitpoints;
    }

    public void setHitpoints(int hitpoints) {
        this.hitpoints = hitpoints;
    }


    public Inventory getInventory() {
        return inventory;
    }
}
