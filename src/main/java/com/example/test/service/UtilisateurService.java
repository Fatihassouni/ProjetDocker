package com.example.test.service;

import com.example.test.Entity.Utilisateur;

import java.util.List;

public interface UtilisateurService {

     Utilisateur saveUtilisateur(Utilisateur utilisateur);
     List<Utilisateur> getAllUtilisateurs();
     Utilisateur getUtilisateurById(Integer id);
     Utilisateur updateUtilisateur(Utilisateur utilisateur, Integer id);
     void deleteUtilisateur(Integer id);
}
