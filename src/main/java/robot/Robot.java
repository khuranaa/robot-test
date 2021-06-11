package robot;

import java.io.Console;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Robot {

    private static final Map<String, Direction> DIRECTION_MOVEMENT = new HashMap();

    private static final String REPORT = "REPORT";
    private static final String MOVE = "MOVE";
    private static final String INPUT_MESSAGE = "Please type your input:";
    private static final String OUTPUT_MESSAGE = "Output: ";
    private static final String SPACE = " ";
    private static final String PLACE = "PLACE";
    private static final String INCORRECT_FIRST_INPUT_MESSAGE = "Incorrect input, correct format PLACE 0,1,NORTH";
    private static final String COMMA = ",";

    private static Position currentPosition;

    private static boolean onTable = false;

    static {
        DIRECTION_MOVEMENT.put("NORTH_LEFT", Direction.WEST);
        DIRECTION_MOVEMENT.put("NORTH_RIGHT", Direction.EAST);
        DIRECTION_MOVEMENT.put("EAST_LEFT", Direction.NORTH);
        DIRECTION_MOVEMENT.put("EAST_RIGHT", Direction.SOUTH);
        DIRECTION_MOVEMENT.put("WEST_LEFT", Direction.SOUTH);
        DIRECTION_MOVEMENT.put("WEST_RIGHT", Direction.NORTH);
        DIRECTION_MOVEMENT.put("SOUTH_LEFT", Direction.EAST);
        DIRECTION_MOVEMENT.put("SOUTH_RIGHT", Direction.WEST);
    }

    public static void main(String[] args) {
        Console c = System.console();
        while (true) {
            try {
                String input = c.readLine(INPUT_MESSAGE);
                if (!onTable) {
                    placeOnTable(input);
                    continue;
                }
                if (input.equals(REPORT)) {
                    //out of table
                    onTable = false;
                    System.out.println(OUTPUT_MESSAGE + currentPosition);
                } else {
                    performFurtherMoves(input);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }
        }
    }

    private static void performFurtherMoves(String input) {
        if (input.equals(MOVE)) {
            currentPosition.move();
        } else if (input.equals(Move.LEFT) ||
                input.equals(Move.RIGHT)) {
            Direction newDirection = DIRECTION_MOVEMENT.get(currentPosition.getDirection().name()
                    + Move.getMove(input).name());
            currentPosition.setDirection(newDirection);
        } else {
            throw new IllegalArgumentException("Incorrect input, use one of RIGHT or LEFT or MOVE");
        }
    }

    private static void placeOnTable(String input) {
        String[] inputs = extractInput(input.trim());
        String positionString = inputs[1];
        //place on table
        Position position = extractPosition(positionString);
        currentPosition = position;
        onTable = true;
    }

    private static String[] extractInput(String input) {
        String[] inputs = input.split(SPACE);
        if (inputs.length != 2 ||
                !inputs[0].equals(PLACE)) {
            throw new IllegalArgumentException(INCORRECT_FIRST_INPUT_MESSAGE);
        }
        return inputs;
    }

    private static Position extractPosition(String value) {
        String[] values = value.split(COMMA);
        if (values.length != 3) {
            throw new IllegalArgumentException("Invalid input: " + value + " please provide X,Y,F ");
        } else {
            try {
                Integer x = Integer.parseInt(values[0]);
                Integer y = Integer.parseInt(values[1]);
                Direction direction = Direction.getDirection(values[2]);
                Position position = new Position();
                position.setDirection(direction);
                BoundInteger axis = new BoundInteger(x, y);
                position.setCurrentPosition(axis);
                return position;
            } catch (Exception e) {
                throw new IllegalArgumentException("Invalid location" + values[0] + "," + values[1]);
            }
        }
    }

}