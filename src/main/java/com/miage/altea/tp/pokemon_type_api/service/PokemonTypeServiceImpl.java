package com.miage.altea.tp.pokemon_type_api.service;

import com.miage.altea.tp.pokemon_type_api.bo.PokemonType;
import com.miage.altea.tp.pokemon_type_api.repository.PokemonTypeRepository;
import com.miage.altea.tp.pokemon_type_api.repository.TranslationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokemonTypeServiceImpl implements PokemonTypeService {

    public PokemonTypeRepository pokemonTypeRepository;
    public TranslationRepository translationRepository;

    @Override
    public PokemonType getPokemonTypeById(int id) {
        String name = this.translationRepository.getPokemonName(id, LocaleContextHolder.getLocale());
        PokemonType pokemonType = this.pokemonTypeRepository.findPokemonTypeById(id);

        pokemonType.setName(name);
        return pokemonType;
    }

    @Override
    public PokemonType getPokemonTypeByName(String name) {
        return this.pokemonTypeRepository.findPokemonTypeByName(name);
    }

    @Override
    public List<PokemonType> findPokemonsWithListOfTypes(List<String> types) {
        return this.pokemonTypeRepository.findPokemonsWithListOfTypes(types);
    }

    @Override
    public List<PokemonType> getAllPokemonTypes () {
        List<PokemonType> pokemonTypes = this.pokemonTypeRepository.findAllPokemonType();
        return pokemonTypes.stream().peek(type -> {
            String name = this.translationRepository.getPokemonName(type.getId(), LocaleContextHolder.getLocale());
            type.setName(name);
        }).collect(Collectors.toList());
    }

    @Autowired
    public void setPokemonTypeRepository(PokemonTypeRepository pokemonTypeRepository) {
        this.pokemonTypeRepository = pokemonTypeRepository;
    }

    @Autowired
    public void setTranslationRepository(TranslationRepository translationRepository) {
        this.translationRepository = translationRepository;
    }
}