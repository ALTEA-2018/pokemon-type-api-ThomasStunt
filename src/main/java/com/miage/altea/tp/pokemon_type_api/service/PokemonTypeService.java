package com.miage.altea.tp.pokemon_type_api.service;

import com.miage.altea.tp.pokemon_type_api.bo.PokemonType;

import java.util.List;

public interface PokemonTypeService {
    PokemonType getPokemonTypeById(int id);
    PokemonType getPokemonTypeByName(String name);
    List<PokemonType> findPokemonsWithListOfTypes(List<String> types);
    List<PokemonType> getAllPokemonTypes();
}