package com.esprit.foyer.controllers;

import com.esprit.foyer.dto.ChambreDTO;
import com.esprit.foyer.services.ChambreService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/chambre")
public class ChambreController {

    private final ChambreService chambreService;

    @PostMapping("/add")
    public ChambreDTO addChambre(@RequestBody ChambreDTO chambreDTO) {
        return chambreService.addOrUpdateChambre(chambreDTO);
    }

    @PutMapping("/update")
    public ChambreDTO updateChambre(@RequestBody ChambreDTO chambreDTO) {
        return chambreService.addOrUpdateChambre(chambreDTO);
    }

    @GetMapping("/getAll")
    public List<ChambreDTO> getAllChambres() {
        return chambreService.findAllChambres();
    }

    @GetMapping("/get/{id}")
    public ChambreDTO getChambreById(@PathVariable("id") Long idChambre) {
        return chambreService.findChambreById(idChambre);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteChambreById(@PathVariable("id") Long idChambre) {
        chambreService.deleteChambreById(idChambre);
    }
}
