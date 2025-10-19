package com.esprit.foyer.controllers;

import com.esprit.foyer.entities.Bloc;
import com.esprit.foyer.services.BlocService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/blocController")
public class BlocController {
    final BlocService blocService;

    @PostMapping("/addBloc")
    public Bloc addBloc(@RequestBody Bloc bloc) {
        return blocService.addOrUpdateBloc(bloc);
    }

    @PutMapping("/updateBloc")
    public Bloc updateBloc(@RequestBody Bloc bloc) {
        return blocService.addOrUpdateBloc(bloc);
    }

    @GetMapping("/findAllBlocs")
    public List<Bloc> findAllBlocs() {
        return blocService.findAllBlocs();
    }

    @DeleteMapping("/deleteBlocBy")
    public void deleteBlocBy(@RequestParam long idBloc) {
        blocService.deleteBlocById(idBloc);
    }


}
