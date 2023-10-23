package com.diemminhtri.testcustomlistview2;

public class Winner
{
    private String name;
    private String avatar;
    private int prize;

    public Winner(String name, String avatar, int prize) {
        this.name = name;
        this.avatar = avatar;
        this.prize = prize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getPrize() {
        return prize;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }
}
