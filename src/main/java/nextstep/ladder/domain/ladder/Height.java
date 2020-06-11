package nextstep.ladder.domain.ladder;

import java.util.Objects;

public class Height {

    public final static int MINIMUM_HEIGHT = 0;

    private final int height;

    private Height(int height) {
        this.height = height;
    }

    public static Height of(int height) {
        validate(height);
        return new Height(height);
    }

    public int getHeight() {
        return height;
    }

    private static void validate(int height) {
        if(height < MINIMUM_HEIGHT) {
            throw new IllegalArgumentException("높이가 0보다 작을 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Height height1 = (Height) o;
        return height == height1.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height);
    }
}