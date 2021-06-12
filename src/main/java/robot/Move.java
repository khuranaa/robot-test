package robot;

import java.util.Arrays;

public enum Move {
    LEFT, RIGHT;

    public static Move getMove(String move) {
        return Arrays.stream(Move.values()).filter(moves -> moves.name().equals(move))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Incorrect move, please choose LEFT or RIGHT"));
    }

}
