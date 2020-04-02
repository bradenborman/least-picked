package com.borman.leastpicked.mappers;

import com.borman.leastpicked.modls.LeaderBoardRow;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LeaderBoardRowMapper implements RowMapper<LeaderBoardRow> {

    @Override
    public LeaderBoardRow mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new LeaderBoardRow(rowNum + 1, rs.getString("full_name"), rs.getInt("points"));
    }

}