package com.example.per2.leagueproject;

public class Champ {
    private String version;
    private String id;
    private String key;
    private String name;

    public Champ() {
    }

    @Override
    public String toString() {
        return "Champ{" +
                "version='" + version + '\'' +
                ", id='" + id + '\'' +
                ", key='" + key + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
