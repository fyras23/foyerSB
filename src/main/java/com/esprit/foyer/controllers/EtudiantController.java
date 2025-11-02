package com.esprit.foyer.controllers;

import com.esprit.foyer.dto.EtudiantDTO;
import com.esprit.foyer.services.EtudiantService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/etudiants")
public class EtudiantController {

    private final EtudiantService etudiantService;

    @PostMapping("/add")
    public EtudiantDTO addEtudiant(@RequestBody EtudiantDTO etudiantDTO) {
        return etudiantService.addOrUpdateEtudiant(etudiantDTO);
    }

    @PutMapping("/update")
    public EtudiantDTO updateEtudiant(@RequestBody EtudiantDTO etudiantDTO) {
        return etudiantService.addOrUpdateEtudiant(etudiantDTO);
    }

    @GetMapping("/all")
    public List<EtudiantDTO> findAllEtudiants() {
        return etudiantService.findAllEtudiants();
    }

    @GetMapping("/{id}")
    public EtudiantDTO findEtudiantById(@PathVariable Long id) {
        return etudiantService.findEtudiantById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEtudiant(@PathVariable Long id) {
        etudiantService.deleteEtudiantById(id);
    }
}
