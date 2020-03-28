package com.borman.leastpicked.modls.request;

public class UpdateSelectionRequest {

    private String userEmail;
    private int newSelected;
    private int activeSeasonId;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getNewSelected() {
        return newSelected;
    }

    public void setNewSelected(int newSelected) {
        this.newSelected = newSelected;
    }

    public int getActiveSeasonId() {
        return activeSeasonId;
    }

    public void setActiveSeasonId(int activeSeasonId) {
        this.activeSeasonId = activeSeasonId;
    }

}