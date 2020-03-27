package com.borman.leastpicked.dao.sql;

public class UserSQL {

    public static String checkUserExists = "SELECT count(*) FROM PLAYERS WHERE email = :userEmail";

}