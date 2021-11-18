package com.SNT.FakeSpotify.controllers;

import java.util.ArrayList;

import com.SNT.FakeSpotify.models.Song;
import com.SNT.FakeSpotify.repositories.SongsRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/song")
public class SongController {
    @Autowired
    SongsRepo repo;

    @PostMapping("/add")
    public Song postSong(@RequestBody Song song) {
        return repo.save(song);
    }

    @GetMapping("/find")
    public ArrayList<Song> finsAllSongs() {
        return repo.findAll();
    }

    @GetMapping("/find/{idSong}")
    public Song findPerId(@PathVariable int idSong){
        return repo.findPerId(idSong);
    }

    @DeleteMapping("/delete")
    public boolean delPerId(@RequestParam(value = "idSong") int idSong){
        return repo.delPerId(idSong);
    } 


}
