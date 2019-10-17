package org.improving.tag;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Entity(name ="exits")
public class Exit {
    @Id
    Long id;

    @Column(name = "Name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "DestinationId")
    private Location destination;


    @ManyToOne
    @JoinColumn(name = "OriginId")
    private Location origin;

    @Transient
    private List<String> aliases = new ArrayList<>();


    public Exit(String name, Location destination, String...aliases) {
        this.name = name;
        this.destination = destination;
        this.aliases.addAll(Arrays.asList(aliases));
    }
    public String getName() {
        return name;
    }

    public Exit() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getDestination() {
        return destination;
    }
    public void setDestination(Location destination) {
        this.destination = destination;
    }

    /*public int getDestinationId() {
        return destinationId;
    }
    public void setDestinationId(int destinationId) {
        this.destinationId = destinationId;
    }*/


    public List<String> getAliases() {
        return aliases;
    }


    public void addAlias(String alias) {
        this.aliases.add(alias);
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, destination);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Exit) {
            Exit exit = (Exit) obj;
            return this.getName().equals(exit.getName()) &&
                    this.getDestination().equals(exit.getDestination());
        }
        return super.equals(obj);
    }

    public Location getOrigin() {
        return origin;
    }

    public void setOrigin(Location origin) {
        this.origin = origin;
    }

    @Column(name = "Aliases")
    private String pAliases;

    @PostLoad
    public void postLoad() {
        if (null != pAliases) {
            Arrays.stream(pAliases.replace(" ", "").split(",")).forEach(alias -> aliases.add(alias));
        }
    }

}
