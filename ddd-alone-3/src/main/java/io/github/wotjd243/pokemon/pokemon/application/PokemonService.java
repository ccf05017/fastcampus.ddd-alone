package io.github.wotjd243.pokemon.pokemon.application;

import io.github.wotjd243.pokemon.pokemon.domain.CaughtPokemonEvent;
import io.github.wotjd243.pokemon.pokemon.domain.NationalPokedexNumber;
import io.github.wotjd243.pokemon.pokemon.domain.Pokemon;
import io.github.wotjd243.pokemon.pokemon.domain.PokemonRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class PokemonService {

    private final PokemonRepository pokemonRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    public PokemonService(PokemonRepository pokemonRepository, ApplicationEventPublisher applicationEventPublisher) {
        this.pokemonRepository = pokemonRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public Pokemon find(final int number) {

        return pokemonRepository.findById(NationalPokedexNumber.valueOf(number));
    }

    public boolean capture(final int pokemonNumber, final int captureRate) {
        final Pokemon pokemon = pokemonRepository.findById(NationalPokedexNumber.valueOf(pokemonNumber));
        if (pokemon.capture(captureRate)) {
            // 이벤트 핸들링
            applicationEventPublisher.publishEvent(new CaughtPokemonEvent(pokemon.getNumber(), pokemon.getName()));

//            trainerService.addPokemon(pokemon.getNumber(), pokemon.getName()); <- 이게 안티 패턴의 근원
        }
        return pokemon.capture(captureRate);
    }
}
