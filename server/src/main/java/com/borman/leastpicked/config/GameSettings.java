package com.borman.leastpicked.config;

import com.borman.leastpicked.modls.gamesettings.Season;
import com.borman.leastpicked.utilities.SeasonUtility;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "game-settings")
public class GameSettings {

    private Integer activeSeasonInt;
    private HashMap<Integer, Season> seasons;

    public Season getActiveSeason() {
        return seasons.get(activeSeasonInt);
    }

    public int getDaysLeftInCurrentSeason() {
        return (int) SeasonUtility.getDaysLeftInCurrentSeason(getActiveSeason().getEndDate());
    }

    public Integer getActiveSeasonInt() {
        return activeSeasonInt;
    }

    public void setActiveSeasonInt(Integer activeSeasonInt) {
        this.activeSeasonInt = activeSeasonInt;
    }

    public HashMap<Integer, Season> getSeasons() {
        return seasons;
    }

    public void setSeasons(HashMap<Integer, Season> seasons) {
        this.seasons = seasons;
    }

}