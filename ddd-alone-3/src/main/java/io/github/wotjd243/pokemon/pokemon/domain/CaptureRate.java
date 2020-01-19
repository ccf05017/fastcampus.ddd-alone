package io.github.wotjd243.pokemon.pokemon.domain;

import java.util.Objects;

public class CaptureRate {

    private static final int MINIMUM_NUMBER = 3;
    private static final int MAXIMUM_NUMBER = 255;

    private final int captureRate;

    public CaptureRate(final int captureRate) {
        validate(captureRate);
        this.captureRate = captureRate;
    }

    // factory method에는 static을 붙여주자
    static CaptureRate valueOf(final int captureRate) {
        return new CaptureRate(captureRate);
    }

    private void validate(final int captureRate) {
        if (captureRate < MINIMUM_NUMBER || captureRate > MAXIMUM_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaptureRate that = (CaptureRate) o;
        return captureRate == that.captureRate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(captureRate);
    }

    boolean capture(final int tryRate) {
        return captureRate < tryRate;
    }

    public int toInt() {
        return captureRate;
    }
}
