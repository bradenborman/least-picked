package com.borman.leastpicked.dao;

import com.borman.leastpicked.dao.sql.UserSQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@Component
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public boolean insertUserIfNecessary(String userEmail, String fullName) {
          if("0".equals(checkUserExists(userEmail))) {

            SimpleJdbcInsert insertLobby = new SimpleJdbcInsert(jdbcTemplate)
                    .withTableName("players")
                    .usingGeneratedKeyColumns("player_id");

            Map<String, Object> parameters = new HashMap<>();
            parameters.put("email", userEmail);
            parameters.put("full_name", fullName);
            return insertLobby.executeAndReturnKey(parameters).intValue() > 0;
        }

        return false;

    }

    private String checkUserExists(String userEmail) {
            return namedParameterJdbcTemplate.queryForObject(UserSQL.checkUserExists,
                    new MapSqlParameterSource().addValue("userEmail", userEmail),
                    String.class
            );
    }

    public String getUsersScoreForSeason(String userEmail, int seasonId) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("userEmail", userEmail);
        params.addValue("seasonId", seasonId);
        return namedParameterJdbcTemplate.queryForObject(UserSQL.getUsersScoreForSeason, params, String.class
        );
    }

    public void getAllUniqueUsersThisSeason(int activeSeason) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("season", activeSeason);
      //  return namedParameterJdbcTemplate.query(SelectionSQL.getAllUniqueUsersThisSeason, params, Mapper);
    }


    //namedParameterJdbcTemplate.update(UserSQL.insertUser, params);
    //MapSqlParameterSource params = new MapSqlParameterSource();
    //params.addValue("userEmail", userEmail);

}