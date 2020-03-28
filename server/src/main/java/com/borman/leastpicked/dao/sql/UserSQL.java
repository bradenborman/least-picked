package com.borman.leastpicked.dao.sql;

public class UserSQL {

    public final static String checkUserExists = "SELECT count(*) FROM PLAYERS WHERE email = :userEmail";

    public final static String getUsersScoreForSeason = "SELECT count(*) FROM PICK_HISTORY WHERE is_Point = true AND season_id = :seasonId AND player_id = ( " +
            "SELECT player_id FROM players WHERE email = :userEmail)";


}