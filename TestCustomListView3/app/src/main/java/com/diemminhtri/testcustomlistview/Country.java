package com.diemminhtri.testcustomlistview;

public class Country {
    private String avatar, name;
    private int population;

    public Country(String avatar, String name, int population) {
        this.avatar = avatar;
        this.name = name;
        this.population = population;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
