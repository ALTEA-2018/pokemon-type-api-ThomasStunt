package com.miage.altea.tp.pokemon_type_api.service;

import com.miage.altea.tp.pokemon_type_api.bo.PokemonType;
import com.miage.altea.tp.pokemon_type_api.repository.PokemonTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonTypeServiceImpl implements PokemonTypeService{

    PokemonTypeRepository pokemonTypeRepository;

    public PokemonTypeServiceImpl(PokemonTypeRepository rep){
        this.pokemonTypeRepository = rep;
    }

    @Override
    public PokemonType getPokemonType(int id) { return pokemonTypeRepository.findPokemonTypeById(id); }

    @Override
    public List<PokemonType> getAllPokemonTypes(){ return pokemonTypeRepository.findAllPokemonType(); }

    @Override
    public PokemonType getPokemonType(String name) { return pokemonTypeRepository.findPokemonTypeByName(name); }

    @Override
    public List<PokemonType> getPokemonTypeByType(List<String> types) { return pokemonTypeRepository.findPokemonsTypeByType(types); }
}