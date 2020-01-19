package io.github.wotjd243.pokemon.trainer.domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;

@Embeddable
@Access(value = AccessType.FIELD)
public class PokemonCaught {

    private int number;
    private String nickname;

    protected PokemonCaught() {
    }

    public PokemonCaught(final int number, final String nickname) {
        this.number = number;
        this.nickname = nickname;
    }

    public int getNumber() {
        return number;
    }

    public String getNickname() {
        return nickname;
    }
}
