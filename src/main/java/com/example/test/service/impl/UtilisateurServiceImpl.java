package com.example.test.service.impl;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.test.Entity.Utilisateur;
import com.example.test.Repository.UtilisateurRepository;
import com.example.test.exception.ResourceNotFoundException;
import com.example.test.service.UtilisateurService;
import org.springframework.stereotype.Service;


@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    private UtilisateurRepository utilisateurRepository;

    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository) {
        super();
        this.utilisateurRepository = utilisateurRepository;
    }

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.matches();
    }

    @Override
    public Utilisateur saveUtilisateur(Utilisateur utilisateur) {

        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    @Override
    public Utilisateur getUtilisateurById(Integer id) {
//		Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);
//		if(utilisateur.isPresent()) {
//			return utilisateur.get();
//		}else {
//			throw new ResourceNotFoundException("Utilisateur", "Id", id);
//		}
        return utilisateurRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Utilisateur", "Id", id));

    }

    @Override
    public Utilisateur updateUtilisateur(Utilisateur utilisateur, Integer id) {
// we need to check whether utilisateur with given id is exist in DB or not
        Utilisateur existingUtilisateur = utilisateurRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Utilisateur", "Id", id));
        if(validate(utilisateur.getEmail()))
        {
            existingUtilisateur.setNom(utilisateur.getNom());
            existingUtilisateur.setPrenom(utilisateur.getPrenom());
            existingUtilisateur.setEmail(utilisateur.getEmail());
            // save existing utilisateur to DB
            utilisateurRepository.save(existingUtilisateur);

        }
        else
        {
            String message="email faux";
        }

        return existingUtilisateur;

    }

    @Override
    public void deleteUtilisateur(Integer id) {

        // check whether a utilisateur exist in a DB or not
        utilisateurRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Utilisateur", "Id", id));
        utilisateurRepository.deleteById(id);
    }

}