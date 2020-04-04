package com.borman.leastpicked.modls.builders;

import com.borman.leastpicked.modls.LeaderBoardRow;
import com.borman.leastpicked.modls.gamesettings.Season;
import com.borman.leastpicked.modls.responses.LeaderBoardResponse;

import java.util.List;

public final class LeaderBoardResponseBuilder {
    private List<LeaderBoardRow> topTenLeaders;
    private Season activeSeason;
    private int daysLeftInActiveSeason;

    private LeaderBoardResponseBuilder() {
    }

    public static LeaderBoardResponseBuilder aLeaderBoardResponse() {
        return new LeaderBoardResponseBuilder();
    }

    public LeaderBoardResponseBuilder withTopTenLeaders(List<LeaderBoardRow> topTenLeaders) {
        this.topTenLeaders = topTenLeaders;
        return this;
    }

    public LeaderBoardResponseBuilder withActiveSeason(Season activeSeason) {
        this.activeSeason = activeSeason;
        return this;
    }

    public LeaderBoardResponseBuilder withDaysLeftInActiveSeason(int daysLeftInActiveSeason) {
        this.daysLeftInActiveSeason = daysLeftInActiveSeason;
        return this;
    }

    public LeaderBoardResponse build() {
        LeaderBoardResponse leaderBoardResponse = new LeaderBoardResponse();
        leaderBoardResponse.setTopTenLeaders(topTenLeaders);
        leaderBoardResponse.setActiveSeason(activeSeason);
        leaderBoardResponse.setDaysLeftInActiveSeason(daysLeftInActiveSeason);
        return leaderBoardResponse;
    }
}
