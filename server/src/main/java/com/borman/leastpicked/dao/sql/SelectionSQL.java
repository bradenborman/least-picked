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


    public static String insertSelectionByEmail = "INSERT INTO pick_history (player_id, picked_day, option_selected) " +
    "VALUES ( " +
            "(SELECT PLAYER_ID FROM players WHERE email = :email), :today, :picked " +
    ");";


    public static String getUsersSelectionToday = "SELECT option_selected FROM pick_history WHERE " +
            "PLAYER_ID = ( SELECT player_id FROM players WHERE email = :email) AND PICKED_DAY = :today";



    public static MapSqlParameterSource getMapSqlParameterForPicking(UpdateSelectionRequest request) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("today", DateManagerUtil.getTodaysDateString());
        parameterSource.addValue("email", request.getUserEmail());
        parameterSource.addValue("picked", request.getNewSelected());
        return parameterSource;
    }

}
