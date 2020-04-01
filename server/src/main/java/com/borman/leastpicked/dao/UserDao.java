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

    public boolean insertUserIfNecessary(String userEmail) {
        Integer id = -1;
        if("0".equals(checkUserExists(userEmail))) {

            SimpleJdbcInsert insertLobby = new SimpleJdbcInsert(jdbcTemplate)
                    .withTableName("players")
                    .usingGeneratedKeyColumns("player_id");

            Map<String, Object> parameters = new HashMap<>();
            parameters.put("email", userEmail);
            id  = (Integer) insertLobby.executeAndReturnKey(parameters);
        }

        return id != -1;

    }

    private String checkUserExists(String userEmail) {
            return namedParameterJdbcTemplate.queryForObject(UserSQL.checkUserExists,
                    new MapSqlParameterSource().addValue("userEmail", userEmail),
                    String.class
            );
    }

    public String getUsersScoreForSeason(String userEmail, String seasonId) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("userEmail", userEmail);
        params.addValue("seasonId", seasonId);
        return namedParameterJdbcTemplate.queryForObject(UserSQL.getUsersScoreForSeason, params, String.class
        );
    }


    //namedParameterJdbcTemplate.update(UserSQL.insertUser, params);
    //MapSqlParameterSource params = new MapSqlParameterSource();
    //params.addValue("userEmail", userEmail);

}