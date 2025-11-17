package com.esprit.foyer.controllers;

import com.esprit.foyer.dto.BlocDTO;
import com.esprit.foyer.dto.BlocFoyerDTO;
import com.esprit.foyer.services.BlocService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/bloc")
public class BlocController {

    private final BlocService blocService;

    @PostMapping("/addBloc")
    public BlocDTO addBloc(@RequestBody BlocDTO blocDTO) {
        return blocService.addOrUpdateBloc(blocDTO);
    }

    @PutMapping("/updateBloc")
    public BlocDTO updateBloc(@RequestBody BlocDTO blocDTO) {
        return blocService.addOrUpdateBloc(blocDTO);
    }

    @GetMapping("/allBlocs")
    public List<BlocDTO> findAllBlocs() {
        return blocService.findAllBlocs();
    }

    @GetMapping("/findBloc/{id}")
    public BlocDTO findBlocById(@PathVariable("id") long idBloc) {
        return blocService.findBlocById(idBloc);
    }

    @DeleteMapping("/deleteBloc/{id}")
    public void deleteBlocBy(@PathVariable("id") long idBloc) {
        blocService.deleteBlocById(idBloc);
    }

    @PostMapping("/addWithNewFoyer")
    public BlocFoyerDTO addBlocWithNewFoyer(@RequestBody BlocFoyerDTO BFdto) {
        return blocService.addBlocWithNewFoyer(BFdto);
    }

    @PutMapping("/{idBloc}/assignFoyer/{idFoyer}")
    public BlocDTO affecterBlocAFoyer(@PathVariable Long idBloc, @PathVariable Long idFoyer) {
        return blocService.assignBlocToFoyer(idBloc, idFoyer);
    }
    @PutMapping("/{idBloc}/desaffecterFoyer")
    public BlocDTO desaffecterBlocDeFoyer(@PathVariable Long idBloc) {
        return blocService.decommissionBlocFoyer(idBloc);
    }

}
