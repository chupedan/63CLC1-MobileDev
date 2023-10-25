package com.diemminhtri.a63131545_thigiuaky;

public class Player {
    private String playerName;
    private String playerAvatar;
    private int playerScores;

    public Player(String playerName, String playerAvatar, int playerScores) {
        this.playerName = playerName;
        this.playerAvatar = playerAvatar;
        this.playerScores = playerScores;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerAvatar() {
        return playerAvatar;
    }

    public void setPlayerAvatar(String playerAvatar) {
        this.playerAvatar = playerAvatar;
    }

    public int getPlayerScores() {
        return playerScores;
    }

    public void setPlayerScores(int playerScores) {
        this.playerScores = playerScores;
    }
}
