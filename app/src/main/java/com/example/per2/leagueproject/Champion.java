package com.example.per2.leagueproject;

import java.util.ArrayList;

public class Champion {
    private ArrayList<Champ> data;

    public Champion() {
    }

    @Override
    public String toString() {
        return "Champion{" +
                "data=" + data +
                '}';
    }

    public ArrayList<Champ> getData() {
        return data;
    }

    public void setData(ArrayList<Champ> data) {
        this.data = data;
    }
}
