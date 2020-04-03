package com.borman.leastpicked.dao.sql;

import com.borman.leastpicked.modls.request.UpdateSelectionRequest;
import com.borman.leastpicked.utilities.DateManagerUtil;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

public class SelectionSQL {

    public static String checkPickExists = "SELECT count(*) FROM pick_history WHERE PLAYER_ID = " +
            " ( SELECT player_id FROM players WHERE email = :email) AND PICKED_DAY = :today";


    public static String updateSelectionByEmail = "UPDATE PICK_HISTORY " +
    "SET option_selected = :picked " +
    "WHERE player_id = ( " +
            "SELECT player_id FROM players WHERE email = :email " +
    ") AND picked_day = :today;";


    public static String insertSelectionByEmail = "INSERT INTO pick_history (player_id, season_id, picked_day, option_selected) " +
    "VALUES ( " +
            "(SELECT PLAYER_ID FROM players WHERE email = :email), :activeSeason, :today, :picked " +
    ");";

    public static String getUsersSelectionToday = "SELECT option_selected FROM pick_history WHERE " +
            "PLAYER_ID = ( SELECT player_id FROM players WHERE email = :email) AND PICKED_DAY = :today";


    public static String getAllTodaysSelections = "SELECT * FROM pick_history WHERE PICKED_DAY = :today";


    public static String updateSelectionWinner = "UPDATE pick_history SET is_point = true WHERE option_selected = :selection AND picked_day = :today";

    public final static String TopTenLeadersThisSeason = "SELECT pick_history.player_id, players.email, players.full_name, count(*) as points FROM pick_history" +
            " INNER JOIN players ON pick_history.player_id=players.player_id" +
            " where season_id = '1' and is_point = true" +
            " GROUP BY players.email" +
            " ORDER BY points desc" +
            " Limit 10;";

    public static MapSqlParameterSource getMapSqlParameterForPicking(UpdateSelectionRequest request) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("today", DateManagerUtil.getTodaysDateString());
        parameterSource.addValue("email", request.getUserEmail());
        parameterSource.addValue("picked", request.getNewSelected());
        parameterSource.addValue("activeSeason", request.getActiveSeasonId());
        return parameterSource;
    }

}
