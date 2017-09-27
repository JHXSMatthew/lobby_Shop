package com.mcndsj.lobbyShop.utils;

import com.mcndsj.JHXSMatthew.Shared.LobbyManager;

import java.sql.*;

/**
 * Created by Matthew on 8/07/2016.
 */
public class SQLUtils {


    public static int isGiven(String name){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        int returnValue = -1;
        try{
            connection = LobbyManager.getInstance().getConnection();
            if(connection == null || connection.isClosed()){
                return returnValue;
            }
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT isGiven FROM `aPremium` Where `name`='"+name+"';");
            if(!resultSet.next()){
                return returnValue;
            }
            returnValue = resultSet.getInt("isGiven");
        }catch(SQLException e){
            e.printStackTrace();
            return returnValue;
        }
        finally {
            if (resultSet != null) try { resultSet.close(); } catch (SQLException e) {e.printStackTrace();}
            if (statement != null) try { statement.close(); } catch (SQLException e) {e.printStackTrace();}
            if (connection != null) try { connection.close(); } catch (SQLException e) {e.printStackTrace();}
        }

        return returnValue;
    }

    public static void setGiven(String name){
        Connection connection = null;
        Statement statement = null;
        try{
            connection = LobbyManager.getInstance().getConnection();
            if(connection == null || connection.isClosed()){
                return ;
            }
            statement = connection.createStatement();
            statement.executeUpdate("UPDATE `aPremium` SET `isGiven`='1' Where `name`='"+name+"';");
        }catch(SQLException e){
            e.printStackTrace();
        }
        finally {
            if (statement != null) try { statement.close(); } catch (SQLException e) {e.printStackTrace();}
            if (connection != null) try { connection.close(); } catch (SQLException e) {e.printStackTrace();}
        }
    }

    public static void deletePremium(String name){
        Connection connection = null;
        Statement statement = null;
        try{
            connection = LobbyManager.getInstance().getConnection();
            if(connection == null || connection.isClosed()){
                return ;
            }
            statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM `aPremium` Where `name`='"+name+"';");
        }catch(SQLException e){
            e.printStackTrace();
        }
        finally {
            if (statement != null) try { statement.close(); } catch (SQLException e) {e.printStackTrace();}
            if (connection != null) try { connection.close(); } catch (SQLException e) {e.printStackTrace();}
        }
    }
}
