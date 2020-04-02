package com.borman.leastpicked.dao;

import com.borman.leastpicked.dao.sql.SelectionSQL;
import com.borman.leastpicked.mappers.DetailedPickHistoryRowMapper;
import com.borman.leastpicked.mappers.LeaderBoardRowMapper;
import com.borman.leastpicked.modls.LeaderBoardRow;
import com.borman.leastpicked.modls.database.DetailedPickHistory;
import com.borman.leastpicked.modls.request.UpdateSelectionRequest;
import com.borman.leastpicked.utilities.DateManagerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SelectionDao {

    private Logger logger = LoggerFactory.getLogger(SelectionDao.class);

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public SelectionDao(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

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
            return null;//No pick was made today
        }
    }

    public List<DetailedPickHistory> getAllTodaysSelections(String today) {
        MapSqlParameterSource params = new MapSqlParameterSource().addValue("today", today);
        return namedParameterJdbcTemplate.query(SelectionSQL.getAllTodaysSelections, params, new DetailedPickHistoryRowMapper());
    }


    public void setSelectionAsWinner(Integer selectionToUpdate, String dateString) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("selection", selectionToUpdate);
        params.addValue("today", dateString);
        namedParameterJdbcTemplate.update(SelectionSQL.updateSelectionWinner, params);
    }

    public void clearTodaysWinnerAsCaution(String dateString) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("today", dateString);
        namedParameterJdbcTemplate.update("UPDATE pick_history SET is_point = false WHERE picked_day = :today", params);
    }

    public List<LeaderBoardRow> getTopTenLeadersThisSeason(String activeSeason) {
        MapSqlParameterSource params = new MapSqlParameterSource().addValue("season", activeSeason);
        return namedParameterJdbcTemplate.query(SelectionSQL.TopTenLeadersThisSeason, params, new LeaderBoardRowMapper());
    }
}