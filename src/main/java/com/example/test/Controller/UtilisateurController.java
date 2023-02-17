package com.example.test.Controller;

import com.example.test.Entity.Utilisateur;
import com.example.test.service.UtilisateurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/utilisateurs")
@CrossOrigin("http://localhost:3000/")
public class UtilisateurController {

    private UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService) {
        super();
        this.utilisateurService = utilisateurService;
    }

    // build create utilisateur REST API
    @PostMapping()
    public ResponseEntity<Utilisateur> saveUtilisateur(@RequestBody Utilisateur utilisateur){
        return new ResponseEntity<Utilisateur>(utilisateurService.saveUtilisateur(utilisateur), HttpStatus.CREATED);
    }

    // build get all utilisateurs REST API
    @GetMapping
    public List<Utilisateur> getAllUtilisateurs(){
        return utilisateurService.getAllUtilisateurs();
    }

    // build get utilisateur by id REST API
    // http://localhost:8081/api/utilisateurs/1
    @GetMapping("{id}")
    public ResponseEntity<Utilisateur> getUtilisateurById(@PathVariable("id") Integer utilisateurId){
        return new ResponseEntity<Utilisateur>(utilisateurService.getUtilisateurById(utilisateurId), HttpStatus.OK);
    }

    // build update utilisateur REST API
    // http://localhost:8081/api/utilisateurs/1
    @PutMapping("{id}")
    public ResponseEntity<Utilisateur> updateUtilisateur(@PathVariable("id") Integer id
            ,@RequestBody Utilisateur utilisateur){
        return new ResponseEntity<Utilisateur>(utilisateurService.updateUtilisateur(utilisateur, id), HttpStatus.OK);
    }

    // build delete utilisateur REST API
    // http://localhost:8081/api/utilisateurs/1
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUtilisateur(@PathVariable("id") Integer id){

        // delete utilisateur from DB
        utilisateurService.deleteUtilisateur(id);

        return new ResponseEntity<String>("Utilisateur deleted successfully!.", HttpStatus.OK);
    }

}

