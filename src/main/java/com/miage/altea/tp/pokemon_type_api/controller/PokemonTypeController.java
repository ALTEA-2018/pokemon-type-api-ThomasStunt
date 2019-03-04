package com.miage.altea.tp.pokemon_type_api.controller;

import com.miage.altea.tp.pokemon_type_api.bo.PokemonType;
import com.miage.altea.tp.pokemon_type_api.service.PokemonTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pokemon-types")
public class PokemonTypeController {

    private PokemonTypeService pokemonTypeService;

    @Autowired
    public void setPokemonTypeService(PokemonTypeService pokemonTypeService) {
        this.pokemonTypeService = pokemonTypeService;
    }

    @GetMapping(value = "", params = "id")
    public PokemonType getPokemonTypeById(@RequestParam Integer id){
        return this.pokemonTypeService.getPokemonTypeById(id);
    }

    @GetMapping(value = "", params = "name")
    public PokemonType getPokemonTypeByName(@RequestParam String name){
        return this.pokemonTypeService.getPokemonTypeByName(name);
    }

    @GetMapping(value = "", params = "types")
    public List<PokemonType> getPokemonTypeByTypes(@RequestParam List<String> types){
        return this.pokemonTypeService.findPokemonsWithListOfTypes(types);
    }

    @GetMapping("/")
    public List<PokemonType> getAllPokemonTypes() {
        return this.pokemonTypeService.getAllPokemonTypes();
    }
}