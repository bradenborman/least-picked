package com.borman.leastpicked.modls.request;

public class UpdateSelectionRequest {

    private String userEmail;
    private int newSelected;

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

}