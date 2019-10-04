package org.improving.tag;

import org.improving.tag.items.Item;
import org.improving.tag.items.UniqueItems;

public class Adversary {
    private String name;
    private int property;
    private int hitPoints;
    private int damageTaken;
    private int attackDamage;
    private Inventory inventory;
    private Item item;

    public Adversary(String name) {
        this.name = name;
        this.hitPoints = 30;
        this.damageTaken = 0;
        this.attackDamage = 10;
        this.inventory = new Inventory();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProperty() {
        return property;
    }

    public void setProperty(int property) {
        this.property = property;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getDamageTaken() {
        return damageTaken;
    }

    public void setDamageTaken(int damageTaken) {
        this.damageTaken = damageTaken;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public Inventory getInventory() {
        return inventory;
    }
}
