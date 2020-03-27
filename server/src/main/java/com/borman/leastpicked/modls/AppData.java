package com.borman.leastpicked.modls;

import java.util.List;

public class AppData {

    private String userEmail;
    private String userName;
    private int userScore;
    private boolean usersFirstTime;
    private List<GameOption> options;
    private int activeOption = -1;

    private String activeSeason;
    private int daysUntilNextSeason;
    private int highScore;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserScore() {
        return userScore;
    }

    public void setUserScore(int userScore) {
        this.userScore = userScore;
    }

    public boolean isUsersFirstTime() {
        return usersFirstTime;
    }

    public void setUsersFirstTime(boolean usersFirstTime) {
        this.usersFirstTime = usersFirstTime;
    }

    public List<GameOption> getOptions() {
        return options;
    }

    public void setOptions(List<GameOption> options) {
        this.options = options;
    }


    public int getActiveOption() {
        return activeOption;
    }

    public void setActiveOption(int activeOption) {
        this.activeOption = activeOption;
    }

    public String getActiveSeason() {
        return activeSeason;
    }

    public void setActiveSeason(String activeSeason) {
        this.activeSeason = activeSeason;
    }

    public int getDaysUntilNextSeason() {
        return daysUntilNextSeason;
    }

    public void setDaysUntilNextSeason(int daysUntilNextSeason) {
        this.daysUntilNextSeason = daysUntilNextSeason;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }
}