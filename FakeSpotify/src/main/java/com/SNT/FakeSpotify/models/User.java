package com.SNT.FakeSpotify.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
   private int idUser;
   private String username, pass;
   private boolean premium;
}

