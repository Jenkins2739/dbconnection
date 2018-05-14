/**************************************************************************************************
 * Copyright (c) 2018. Code written by Julien Da Silva Ferreira                                   *
 * This file is part of YEP Engine project.                                                       *
 * YEP Engine project can not be copied and/or distributed without                                *
 * the express permission of the owners .                                                         *
 **************************************************************************************************/


import java.sql.*;


public class Main {

    private static boolean isConnected;

    private static Connection getRemoteConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            String dbName = "dbinstance"; //refer to chosen master password or "RDS_DB_NAME" label for more detail
            String userName = "baptiste"; //refer to chosen master password or "RDS_USERNAME" label for more detail
            String password = "zorglub23"; //refer to chosen master password or "RDS_PASSWORD" label for more detail
            String hostname = "dbinstance.cpj3gocrfoud.us-east-1.rds.amazonaws.com"; //refer to RDS label Endpoint or "RDS_HOSTNAME" label for more detail
            String port = "5432";
            String connectionString = "jdbc:postgresql://" + hostname + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password;
            Connection con = DriverManager.getConnection(connectionString);
            isConnected = true;
            return con;
        }
        catch (ClassNotFoundException e) {
            System.err.println("Local Error: " + e.toString());
        }
        catch (SQLException e) {
            System.err.println("SQL Error: " + e.toString());
        }
        return null;
    }

    public static void createTable(Connection parConnect, String parName)
    {
        if(parConnect != null)
        {
            try {
                Statement setupStatement = parConnect.createStatement();
            }
            catch (SQLException e) {
                System.err.println("SQL Error:" + e.toString());
            }
        }

    }

    public static void main(String[] args) {
        try {
            isConnected = false;
            Connection mydbconnection;
            mydbconnection = getRemoteConnection();
            if(isConnected == true)
            {
                mydbconnection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
