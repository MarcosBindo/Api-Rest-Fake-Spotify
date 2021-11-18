package com.SNT.FakeSpotify.repositories;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.SNT.FakeSpotify.models.Song;

import org.springframework.stereotype.Repository;
@Repository
public class SongsRepo extends Repo{

    public Song save(Song song){
        connection = connect();
        try {
            String queryInsert = "INSERT INTO songs (title, artist, duration, album) VALUES (?, ?, ?, ?)";
            PreparedStatement psI = connection.prepareStatement(queryInsert);
            psI.setString(1, song.getTitle());
            psI.setString(2, song.getArtist());
            psI.setDouble(3, song.getDuration());
            psI.setString(4, song.getAlbum());
            psI.execute();
            return song;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Song> findAll() {
        connection = connect();
        ArrayList<Song> songs = new ArrayList<>();
        try {
            String querySelect = "SELECT idSong,title, artist, duration, album FROM songs";
            PreparedStatement psS = connection.prepareStatement(querySelect);
            ResultSet rs = psS.executeQuery();
            Song song = new Song();
            while (rs.next()) {
                song = new Song(rs.getInt("idSong"), rs.getString("title"), rs.getString("artist"), rs.getDouble("duration"), rs.getString("album"));
                songs.add(song);
            }
            return songs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
   
    public Song findPerId(int idSong) {
        connection = connect();
        try {
            String querySelect = "SELECT idSong,title, artist, duration, album FROM songs WHERE idSong = ?";
            PreparedStatement psS = connection.prepareStatement(querySelect);
            psS.setInt(1, idSong);
            ResultSet rs = psS.executeQuery();
            Song song = new Song();
            while (rs.next()) {
                song = new Song(rs.getInt("idSong"), rs.getString("title"), rs.getString("artist"), rs.getDouble("duration"), rs.getString("album"));
            }
            return song;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public boolean delPerId(Integer idSong) {
        connection = connect();
        try {
            String queryDelete = "DELETE FROM songs WHERE idSong = ?";
            PreparedStatement psS = connection.prepareStatement(queryDelete);
            psS.setInt(1, idSong);
            return psS.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("No se pudo eliminar el usuario");
            return false;
        }
    }

}
