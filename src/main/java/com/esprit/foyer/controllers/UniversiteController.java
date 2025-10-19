package com.esprit.foyer.controllers;

import com.esprit.foyer.entities.Universite;
import com.esprit.foyer.services.UniversiteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/universites")
public class UniversiteController {
    final UniversiteService universiteService;

    @PostMapping("/add")
    public Universite addUniversite(@RequestBody Universite universite) {
        return universiteService.addOrUpdateUniversite(universite);
    }

    @PutMapping("/update")
    public Universite updateUniversite(@RequestBody Universite universite) {
        return universiteService.addOrUpdateUniversite(universite);
    }

    @GetMapping("/all")
    public List<Universite> findAllUniversites() {
        return universiteService.findAllUniversites();
    }

    @GetMapping("/{id}")
    public Universite findUniversiteById(@PathVariable Long id) {
        return universiteService.findUniversiteById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUniversite(@PathVariable Long id) {
        universiteService.deleteUniversiteById(id);
    }
}
