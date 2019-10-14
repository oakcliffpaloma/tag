package org.improving.tag;

import org.improving.tag.items.Item;
import org.improving.tag.items.UniqueItems;

import javax.persistence.*;
import java.util.Arrays;

@Entity(name = "adversary")
public class Adversary {
    @Id
    long id;

    @Column(name = "Name")
    private String name;

    private int property;

    @Column(name = "HitPoints")
    private int hitPoints;

    @Column(name = "DamageTaken")
    private int damageTaken;

    @Column(name = "AttackDamage")
    private int attackDamage;

    @Transient
    private Inventory inventory;

    @Column(name = "DropItem")
    private String dropItemDb;


    @Transient
    private Item dropItem = UniqueItems.NOTHING;

    public void setItem(Item item) {
        this.item = item;
    }

    @Transient
    private Item item;

    public Adversary(String name) {
        this.name = name;
        this.hitPoints = 30;
        this.damageTaken = 10;
        this.attackDamage = 5;
        this.inventory = new Inventory();
    }

    public Adversary() {
        
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

    public void setItem() {
    }

    public Item getDropItem() {
        return dropItem;
    }

    public void setDropItem(Item dropItem) {
        this.dropItem = dropItem;
    }

    @PostLoad
    public void postLoad() {
        //String dropItem = result.getString("DropItem");
        if (null != dropItemDb) {
            this.setItem(Arrays
                    .stream(UniqueItems.values())
                    .filter(item -> item.getName().equals(dropItemDb))
                    .findFirst().orElse(null));
        }
    }
}
