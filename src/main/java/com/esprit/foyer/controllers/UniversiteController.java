package com.esprit.foyer.controllers;

import com.esprit.foyer.dto.UniversiteDTO;
import com.esprit.foyer.services.UniversiteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/universites")
public class UniversiteController {

    private final UniversiteService universiteService;

    @PostMapping("/add")
    public UniversiteDTO addUniversite(@RequestBody UniversiteDTO universiteDTO) {
        return universiteService.addOrUpdateUniversite(universiteDTO);
    }

    @PutMapping("/update")
    public UniversiteDTO updateUniversite(@RequestBody UniversiteDTO universiteDTO) {
        return universiteService.addOrUpdateUniversite(universiteDTO);
    }

    @GetMapping("/all")
    public List<UniversiteDTO> findAllUniversites() {
        return universiteService.findAllUniversites();
    }

    @GetMapping("/{id}")
    public UniversiteDTO findUniversiteById(@PathVariable Long id) {
        return universiteService.findUniversiteById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUniversite(@PathVariable Long id) {
        universiteService.deleteUniversiteById(id);
    }
}
