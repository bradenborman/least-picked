package com.borman.leastpicked.mappers;

import com.borman.leastpicked.modls.database.DetailedPickHistory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DetailedPickHistoryRowMapper implements RowMapper<DetailedPickHistory> {

    @Override
    public DetailedPickHistory mapRow(ResultSet rs, int rowNum) throws SQLException {

        DetailedPickHistory ph = new DetailedPickHistory();

        //TODO
        ph.setOptionSelected(rs.getInt("option_selected"));
        ph.setPickedDay(rs.getString("picked_day"));
        ph.setPlayerId(rs.getInt("player_id"));
//
//        ph.setPlayersEmail();

        ph.setSeasonId(rs.getInt("season_id"));

       // ph.setGraded(rs.getBoolean("is_graded"));
        ph.setPoint(rs.getBoolean("is_point"));

        return ph;

    }
}