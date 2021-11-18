package com.SNT.FakeSpotify.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Song {
    private int idSong;
    private String title, artist;
    private double duration;
    private String album;
}
