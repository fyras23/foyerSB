package com.esprit.foyer.controllers;

import com.esprit.foyer.dto.FoyerDTO;
import com.esprit.foyer.services.FoyerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/foyers")
public class FoyerController {

    private final FoyerService foyerService;

    @PostMapping("/add")
    public FoyerDTO addFoyer(@RequestBody FoyerDTO foyerDTO) {
        return foyerService.addOrUpdateFoyer(foyerDTO);
    }

    @PutMapping("/update")
    public FoyerDTO updateFoyer(@RequestBody FoyerDTO foyerDTO) {
        return foyerService.addOrUpdateFoyer(foyerDTO);
    }

    @GetMapping("/all")
    public List<FoyerDTO> findAllFoyers() {
        return foyerService.findAllFoyers();
    }

    @GetMapping("/{id}")
    public FoyerDTO findFoyerById(@PathVariable Long id) {
        return foyerService.findFoyerById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFoyer(@PathVariable Long id) {
        foyerService.deleteFoyerById(id);
    }
}
