package com.discord.bot.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnector {

    public SqlConnector() throws SQLException {
        Connection connection = null;

            connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\zupe1\\Desktop\\TicketDatabank.db.sqbpro");
    }

    public static void main(String[] argh) throws SQLException {
        new SqlConnector();
    }
}
