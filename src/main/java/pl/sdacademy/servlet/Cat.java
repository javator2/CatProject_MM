package pl.sdacademy.servlet;

import java.util.Objects;

public class Cat {
    String race;
    String name;
    String owner;

    public Cat() {};

    public Cat(String race, String name, String owner) {
        this.race = race;
        this.name = name;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "race='" + race + '\'' +
                ", name='" + name + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return Objects.equals(race, cat.race) &&
                Objects.equals(name, cat.name) &&
                Objects.equals(owner, cat.owner);
    }

    @Override
    public int hashCode() {

        return Objects.hash(race, name, owner);
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
