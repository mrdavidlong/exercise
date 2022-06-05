package exercise.randompuzzle;

import java.util.Objects;

public class Piece {
    public int r;
    public int c;

    public Piece(int r, int c) {
        this.r = r;
        this.c = c;
    }

    @Override
    public int hashCode() {
        return Objects.hash(r,c);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Piece)) return false;

        if (obj == this) return true;
        return this.r == ((Piece) obj).r && this.c == ((Piece) obj).c;
    }

}

