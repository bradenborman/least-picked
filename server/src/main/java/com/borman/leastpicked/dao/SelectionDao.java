package com.borman.leastpicked.dao;

import com.borman.leastpicked.dao.sql.SelectionSQL;
import com.borman.leastpicked.modls.request.UpdateSelectionRequest;
import com.borman.leastpicked.utilities.DateManagerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class SelectionDao {

    private Logger logger = LoggerFactory.getLogger(SelectionDao.class);

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public boolean checkForUsersPick(String userEmail) {

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("email", userEmail);
        params.addValue("today", DateManagerUtil.getTodaysDateString());

        return "1".equals(namedParameterJdbcTemplate.queryForObject(SelectionSQL.checkPickExists,
                params,
                String.class
        ));
    }

    public void insertUserPick(UpdateSelectionRequest request) {
        logger.info("insertUserPick");
        MapSqlParameterSource params = SelectionSQL.getMapSqlParameterForPicking(request);
        namedParameterJdbcTemplate.update(SelectionSQL.insertSelectionByEmail, params);
    }

    public void updateUsersPick(UpdateSelectionRequest request) {
        logger.info("updateUsersPick");
        MapSqlParameterSource params = SelectionSQL.getMapSqlParameterForPicking(request);
        namedParameterJdbcTemplate.update(SelectionSQL.updateSelectionByEmail, params);
    }

    public String getUsersSelectionToday(String email) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("email", email);
        params.addValue("today", DateManagerUtil.getTodaysDateString());
        try {
            return namedParameterJdbcTemplate.queryForObject(SelectionSQL.getUsersSelectionToday, params, String.class);
        }catch (Exception e) {
            //No pick was made today
            return null;
        }
    }


}