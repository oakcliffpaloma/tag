package org.improving.tag;

public class Player {
    private String name = "The Player";
    private int hitpoints = 100;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getHitpoints() {
        return hitpoints;
    }

    public void setHitpoints(int hitpoints) {
        this.hitpoints = hitpoints;
    }
}
