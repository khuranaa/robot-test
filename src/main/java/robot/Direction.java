package robot;

import java.util.Arrays;

public enum Direction {
    NORTH, EAST, WEST, SOUTH;

    public static Direction getDirection(String direction) {
        return Arrays.stream(Direction.values())
                .filter(x-> x.name().equals(direction))
                .findAny().orElseThrow(() -> new IllegalArgumentException("Incorrect direction entered.."));
    }
}
