package io.github.wotjd243.pokemon.trainer.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Trainer {

    @Id
    private String id;
    @Embedded
    private TrainerLevel level;

    @ElementCollection      // 실제 객체끼리 연관할 때는 XtoX 관계 설정해줘야 한다.
    private List<PokemonCaught> party = new ArrayList<>();

    protected Trainer() {
    }

    // 처음 만드는 트레이너일 경우의 생성자
    public Trainer(final String id) {
        this(id, 1, new ArrayList<>());
    }

    public Trainer(final String id, final int level, final List<PokemonCaught> party) {
        this.id = id;
        this.level = TrainerLevel.valueOf(level);
        this.party = new ArrayList<>(party);
//        this.party = Collections.unmodifiableList(party); <- 불변일 때만
    }

    public String getId() {
        return id;
    }

    public int getLevel() {
        return level.toInt();
    }

    public void addPokemon(final int number, final String name) {
        party.add(new PokemonCaught(number, name));
        levelUp();
    }

    public List<PokemonCaught> getParty() {
        return new ArrayList<>(party);
    }

    public void levelUp() {
        this.level = this.level.up();
    }
}
