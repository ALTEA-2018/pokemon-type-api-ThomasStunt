package com.miage.altea.tp.pokemon_type_api.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.miage.altea.tp.pokemon_type_api.bo.PokemonType;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PokemonTypeRepositoryImpl implements PokemonTypeRepository {

    private List<PokemonType> pokemons;

    public PokemonTypeRepositoryImpl() {
        try {
            var pokemonsStream = new ClassPathResource("pokemons.json").getInputStream();

            var objectMapper = new ObjectMapper();
            var pokemonsArray = objectMapper.readValue(pokemonsStream, PokemonType[].class);
            this.pokemons = Arrays.asList(pokemonsArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public PokemonType findPokemonTypeById(int id) {
        System.out.println("Loading Pokemon information for Pokemon id " + id);

        for (PokemonType pok : pokemons) {
            if(pok.getId() == id) {
                return pok;
            }
        }

        return null;
    }

    @Override
    public PokemonType findPokemonTypeByName(String name) {
        System.out.println("Loading Pokemon information for Pokemon name " + name);

        for (PokemonType pok : pokemons) {
            if(pok.getName().equals(name)) {
                return pok;
            }
        }

        return null;
    }

    @Override
    public List<PokemonType> findAllPokemonType() {

        return pokemons;
    }

    @Override
    public List<PokemonType> findPokemonsTypeByType(List<String> type) {

        if(type.size() < 2) {
            return this.pokemons.stream()
                    .filter(pokemon -> pokemon.getTypes().stream().anyMatch(type::contains))
                    .collect(Collectors.toList());
        } else {
            List<PokemonType> res = new ArrayList<>();
            for(PokemonType pok : pokemons) {
                Collections.sort(type);
                Collections.sort(pok.getTypes());
                if(type.equals(pok.getTypes())) {
                    res.add(pok);
                }
            }
            return res;
        }
    }

}