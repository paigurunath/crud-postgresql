package com.predix.datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;


public class DBUtility {

    private static String CLASS_NAME = "com.util.DBUtility";
    private static Logger logger = Logger.getLogger(CLASS_NAME);

    public static void closeStatement(Statement stmt) {
        try {
            if (stmt != null) stmt.close();
        } catch (SQLException e) {
            logger.error(CLASS_NAME + ", Exception: ", e);
        }

    }

    public static void closePreparedStatement(PreparedStatement stmt) {
        try {
            if (stmt != null) stmt.close();
        } catch (SQLException e) {
            logger.error(CLASS_NAME + ", Exception: ", e);
        }

    }

    public static void closeResultSet(ResultSet rs) {
        try {
            if (rs != null) rs.close();
        } catch (SQLException e) {
            logger.error(CLASS_NAME + ", Exception: ", e);
        }

    }



    public static void closeConnection(Connection con) {
        try {
            //if (con != null) con.rollback();
            if (con != null) con.close();
        } catch (SQLException e) {
            logger.error(CLASS_NAME + ", Exception: ", e);
        }
    }

}
