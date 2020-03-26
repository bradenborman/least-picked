package com.borman.leastpicked.modls;

import java.util.List;

public class AppData {

    private String userEmail;
    private List<GameOption> options;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public List<GameOption> getOptions() {
        return options;
    }

    public void setOptions(List<GameOption> options) {
        this.options = options;
    }
}