package ru.job4j.tracker;


import javax.persistence.*;

@Entity
@Table(name = "items")
public class Item implements Comparable<Item> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;


    public Item(String name) {
        this.name = name;
    }

    public Item(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Item() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item{"
                +
                "id = "
                +
                id
                +
                '\''
                +
                ", name = '"
                +
                name
                +
                '\''
                +
                "}";
    }

    @Override
    public int compareTo(Item another) {
        return CharSequence.compare(name, another.name);
    }
}