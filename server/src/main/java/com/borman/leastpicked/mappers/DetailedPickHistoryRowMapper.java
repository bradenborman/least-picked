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
//        ph.setOptionSelected();
//        ph.setPickedDay();
//        ph.setPlayerId();
//        ph.setPlayerId();
//        ph.setPlayersEmail();
//        ph.setSeasonId();

        return ph;
    }
}