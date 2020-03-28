package com.borman.leastpicked.modls.database;

public class DetailedPickHistory {

    private int pickId;
    private int playerId;
    private String pickedDay;
    private int optionSelected;
    private String playersEmail;
    private int seasonId;

    private boolean isGraded;
    private boolean isPoint;

    public int getPickId() {
        return pickId;
    }

    public void setPickId(int pickId) {
        this.pickId = pickId;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getPickedDay() {
        return pickedDay;
    }

    public void setPickedDay(String pickedDay) {
        this.pickedDay = pickedDay;
    }

    public int getOptionSelected() {
        return optionSelected;
    }

    public void setOptionSelected(int optionSelected) {
        this.optionSelected = optionSelected;
    }

    public String getPlayersEmail() {
        return playersEmail;
    }

    public void setPlayersEmail(String playersEmail) {
        this.playersEmail = playersEmail;
    }

    public int getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(int seasonId) {
        this.seasonId = seasonId;
    }

    public boolean isGraded() {
        return isGraded;
    }

    public void setGraded(boolean graded) {
        isGraded = graded;
    }

    public boolean isPoint() {
        return isPoint;
    }

    public void setPoint(boolean point) {
        isPoint = point;
    }
}