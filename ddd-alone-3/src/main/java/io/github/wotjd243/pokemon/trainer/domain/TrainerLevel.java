package io.github.wotjd243.pokemon.trainer.domain;

import javax.persistence.Embeddable;
import java.util.Objects;

// VO
@Embeddable
public class TrainerLevel {

    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 30;

    private int trainerLevel;

    protected TrainerLevel() {
    }

    public TrainerLevel(final int trainerLevel) {
        validate(trainerLevel);
        this.trainerLevel = trainerLevel;
    }

    private void validate(int trainerLevel) {
        if (trainerLevel < MINIMUM_NUMBER || trainerLevel > MAXIMUM_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    public int toInt() {
        return this.trainerLevel;
    }

    public static TrainerLevel valueOf(final int trainerLevel) {
        return new TrainerLevel(trainerLevel);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrainerLevel that = (TrainerLevel) o;
        return trainerLevel == that.trainerLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(trainerLevel);
    }

    public TrainerLevel up() {
        return new TrainerLevel(this.trainerLevel + 1);
    }
}
