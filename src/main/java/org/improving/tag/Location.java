package org.improving.tag;

import org.improving.tag.items.Item;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Location {
    private int id;
    private String name = "";
    private String description = "";
    private List<String> tags = new ArrayList<>();
    private List<Exit> exits = new ArrayList<>();
    private Adversary adversary;
    private TreasureChest treasureChest = TreasureChest.NO_TREASURE;
   //private Collection<Exit> exit;


    public Adversary getAdversary() {
        return adversary;
    }

    public void setAdversary(Adversary adversary) {
        this.adversary = adversary;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getTags() {
        return tags;
    }

    public List<Exit> getExits() {
        return exits;
    }

    public void setTreasureChest(TreasureChest treasureChest) {
        this.treasureChest = treasureChest;
    }

    public String getTreasureDescription() {
        return treasureChest.getDescription();
    }

    public Item openTreasureChest() {
    Item treasure = treasureChest.getItem();
    treasureChest = TreasureChest.NO_TREASURE;
    return treasure;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Location) {
            Location location  = (Location) obj;
            return this.getName().equals(location.getName()) &&
                    this.getDescription().equals(location.getDescription());
        }
        return super.equals(obj);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void addExit(Exit exit) {
        this.exits.add(exit);
    }

    /*public Item openTreasure() {
        if(TreasureChest.NO_TREASURE.equals(treasureChest)){
            throw new UnsupportedOperationException());}
        return treasureChest.getItem();
        }*/

}
