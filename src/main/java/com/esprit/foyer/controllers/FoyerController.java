package com.esprit.foyer.controllers;

import com.esprit.foyer.entities.Foyer;
import com.esprit.foyer.services.FoyerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/foyers")
public class FoyerController {
    final FoyerService foyerService;

    @PostMapping("/add")
    public Foyer addFoyer(@RequestBody Foyer foyer) {
        return foyerService.addOrUpdateFoyer(foyer);
    }

    @PutMapping("/update")
    public Foyer updateFoyer(@RequestBody Foyer foyer) {
        return foyerService.addOrUpdateFoyer(foyer);
    }

    @GetMapping("/all")
    public List<Foyer> findAllFoyers() {
        return foyerService.findAllFoyers();
    }

    @GetMapping("/{id}")
    public Foyer findFoyerById(@PathVariable Long id) {
        return foyerService.findFoyerById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFoyer(@PathVariable Long id) {
        foyerService.deleteFoyerById(id);
    }
}
