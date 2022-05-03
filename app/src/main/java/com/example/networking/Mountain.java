package com.example.networking;

public class Mountain {

    // Attributes
    private String ID, name, location;
    private int size, cost;
    private Auxdata auxdata;

    // Constructor
    public Mountain(String id, String name, String location, int size, int cost, Auxdata auxdata) {
        this.ID = id;
        this.name = name;
        this.location = location;
        this.size = size;
        this.cost = cost;
        this.auxdata = auxdata;
    }

    public String getId() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getSize() {
        return Integer.toString(size);
    }

    public String getCost() {
        return Integer.toString(cost);
    }

    public Auxdata getAuxdata() {
        return auxdata;
    }
}
