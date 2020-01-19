package io.github.wotjd243.pokemon.pokemon.ui;

import io.github.wotjd243.pokemon.pokemon.application.PokemonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokemonRestController {

    private final PokemonService pokemonService;

    public PokemonRestController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/api/pokemons/{id}")
    public ResponseEntity find(@PathVariable(name = "id") int number) {

        return ResponseEntity.ok().body(pokemonService.find(number));
    }

    @GetMapping("/api/pokemons/{number}/{captureRate}")
    public ResponseEntity capture(
            @PathVariable final int number,
            @PathVariable final int captureRate
    ) {
        return ResponseEntity.ok().body(pokemonService.capture(number, captureRate));
    }
}
