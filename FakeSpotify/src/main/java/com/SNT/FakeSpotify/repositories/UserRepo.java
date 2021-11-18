package com.SNT.FakeSpotify.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.SNT.FakeSpotify.models.User;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepo extends Repo {

    public User save(User user) {
        connection = connect();
        try {
            String queryInsert = "INSERT INTO users (username, pass, premium) VALUES (?, ?, ?)";
            PreparedStatement psI = connection.prepareStatement(queryInsert);
            psI.setString(1, user.getUsername());
            psI.setString(2, user.getPass());
            System.out.println(user.isPremium());
            psI.setBoolean(3, user.isPremium());
            psI.execute();
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<User> findAll() {
        connection = connect();
        ArrayList<User> users = new ArrayList<User>();
        try {
            String querySelect = "SELECT idUser,username,pass,premium FROM users";
            PreparedStatement psS = connection.prepareStatement(querySelect);
            ResultSet rs = psS.executeQuery();
            User user = new User();
            while (rs.next()) {
                user = new User(rs.getInt("idUser"), rs.getString("username"), rs.getString("pass"),
                        rs.getBoolean("premium"));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public User findPerId(int idUser) {
        connection = connect();
        try {
            String querySelect = "SELECT idUser,username,pass,premium FROM users WHERE idUser = ?";
            PreparedStatement psS = connection.prepareStatement(querySelect);
            psS.setInt(1, idUser);
            ResultSet rs = psS.executeQuery();
            User user = new User();
            while (rs.next()) {
                user = new User(rs.getInt("idUser"), rs.getString("username"), rs.getString("pass"),
                        rs.getBoolean("premium"));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<User> findPerType(boolean type) {
        connection = connect();
        ArrayList<User> users = new ArrayList<User>();
        try {
            String querySelect = "SELECT idUser,username,pass,premium FROM users WHERE premium = ?";
            PreparedStatement psS = connection.prepareStatement(querySelect);
            psS.setBoolean(1, type);
            ResultSet rs = psS.executeQuery();
            User user = new User();
            while (rs.next()) {
                user = new User(rs.getInt("idUser"), rs.getString("username"), rs.getString("pass"),
                        rs.getBoolean("premium"));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean delPerId(Integer idUser) {
        connection = connect();
        try {
            String queryDelete = "DELETE FROM users WHERE idUser = ?";
            PreparedStatement psS = connection.prepareStatement(queryDelete);
            psS.setInt(1, idUser);
            return psS.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("No se pudo eliminar el usuario");
            return false;
        }
    }

}
