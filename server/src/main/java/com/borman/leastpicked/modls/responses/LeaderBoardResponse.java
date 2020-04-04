package com.borman.leastpicked.modls.responses;

import com.borman.leastpicked.modls.LeaderBoardRow;
import com.borman.leastpicked.modls.gamesettings.Season;

import java.util.List;

public class LeaderBoardResponse {

    private List<LeaderBoardRow> topTenLeaders;
    private Season activeSeason;
    private int daysLeftInActiveSeason;

    public List<LeaderBoardRow> getTopTenLeaders() {
        return topTenLeaders;
    }

    public void setTopTenLeaders(List<LeaderBoardRow> topTenLeaders) {
        this.topTenLeaders = topTenLeaders;
    }

    public Season getActiveSeason() {
        return activeSeason;
    }

    public void setActiveSeason(Season activeSeason) {
        this.activeSeason = activeSeason;
    }

    public int getDaysLeftInActiveSeason() {
        return daysLeftInActiveSeason;
    }

    public void setDaysLeftInActiveSeason(int daysLeftInActiveSeason) {
        this.daysLeftInActiveSeason = daysLeftInActiveSeason;
    }

}