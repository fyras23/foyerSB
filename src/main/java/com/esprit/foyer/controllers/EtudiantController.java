package com.esprit.foyer.controllers;

import com.esprit.foyer.entities.Etudiant;
import com.esprit.foyer.services.EtudiantService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/etudiants")
public class EtudiantController {
    final EtudiantService etudiantService;

    @PostMapping("/add")
    public Etudiant addEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.addOrUpdateEtudiant(etudiant);
    }

    @PutMapping("/update")
    public Etudiant updateEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.addOrUpdateEtudiant(etudiant);
    }

    @GetMapping("/all")
    public List<Etudiant> findAllEtudiants() {
        return etudiantService.findAllEtudiants();
    }

    @GetMapping("/{id}")
    public Etudiant findEtudiantById(@PathVariable Long id) {
        return etudiantService.findEtudiantById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEtudiant(@PathVariable Long id) {
        etudiantService.deleteEtudiantById(id);
    }
}
