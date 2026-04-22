package model;

import java.util.Map;

public class User {
    private int id;
    private String name;
    private Map<Integer,Group> groups;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
