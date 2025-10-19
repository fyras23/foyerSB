package com.esprit.foyer.controllers;

import com.esprit.foyer.entities.Chambre;
import com.esprit.foyer.services.ChambreService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/chambre")
public class ChambreController {
    final ChambreService chambreService;

    @PostMapping("/add")
    public Chambre addChambre(@RequestBody Chambre chambre) {
        return chambreService.addOrUpdateChambre(chambre);
    }
@PutMapping("/update")
    public Chambre updateChambre(@RequestBody Chambre chambre) {
        return chambreService.addOrUpdateChambre(chambre);
    }

    @GetMapping("/getAll")
     public List<Chambre> getAllChambres() {
        return chambreService.findAllChambres();}

    @DeleteMapping("/deleteBy")
    public void deleteChambreById(@RequestParam("idChambre") long idChambre) {
        chambreService.deleteChambreById(idChambre);
    }

}
