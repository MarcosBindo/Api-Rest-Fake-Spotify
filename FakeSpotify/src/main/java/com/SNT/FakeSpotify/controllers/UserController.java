package com.SNT.FakeSpotify.controllers;

import java.util.ArrayList;

import com.SNT.FakeSpotify.models.User;
import com.SNT.FakeSpotify.repositories.UserRepo;

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
@RequestMapping (path = "/user")
public class UserController {
    @Autowired
    UserRepo repo;

    @PostMapping("/add")
    public User postUser(@RequestBody User user){
        return repo.save(user);
    }

    @GetMapping("/find")
    public ArrayList<User> findAllUsers(){
        return repo.findAll();
    }

    @GetMapping("/find/{idUser}")
    public User findPerId(@PathVariable int idUser){
        return repo.findPerId(idUser);
    }

    @GetMapping("/findType")
    public ArrayList<User> findPerType(@RequestParam(value = "premium") boolean type){
        return repo.findPerType(type);
    } 

    @DeleteMapping("/delete")
    public boolean delPerId(@RequestParam(value = "idUser") int idUser){
        return repo.delPerId(idUser);
    } 
}
