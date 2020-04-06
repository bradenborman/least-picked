package com.borman.leastpicked.mappers;

import com.borman.leastpicked.modls.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LeaderMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new User(rs.getInt("player_id"), rs.getString("email"));
    }

}