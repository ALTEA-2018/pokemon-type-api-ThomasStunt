package com.miage.altea.tp.pokemon_type_api.controller;

import com.miage.altea.tp.pokemon_type_api.bo.PokemonType;
import com.miage.altea.tp.pokemon_type_api.service.PokemonTypeService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pokemon-types")
class PokemonTypeController {

    PokemonTypeService service;

    public PokemonTypeController(PokemonTypeService service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<PokemonType> getAllPokemonTypes(@RequestParam(value = "id", required = false) Integer id,
                                                @RequestParam(value = "name", required = false) String name,
                                                @RequestParam(value = "types", required = false) List<String> types) {
        System.out.println();
        List<PokemonType> res = new ArrayList<>();

        if(id != null) {
            res.add(getPokemonTypeFromId(id));
        } else if(name != null) {
            res.add(getPokemonTypeFromName(name));
        } else if(types != null) {
            res.addAll(getPokemonTypesFromTypes(types));
        } else {
            res.addAll(service.getAllPokemonTypes());
        }

        return res;
    }

    public PokemonType getPokemonTypeFromId(@PathVariable int id){ return service.getPokemonType(id); }

    public PokemonType getPokemonTypeFromName(@PathVariable String name) { return service.getPokemonType(name); }

    public List<PokemonType> getPokemonTypesFromTypes(@PathVariable List<String> types) { return service.getPokemonTypeByType(types); }
}