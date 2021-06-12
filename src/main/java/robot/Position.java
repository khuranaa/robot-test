package robot;

public class Position {
    private BoundInteger currentPosition;

    private Direction direction;

    public Position() {
    }

    public Position(BoundInteger currentPosition, Direction direction) {
        this.currentPosition = currentPosition;
        this.direction = direction;
    }

    public BoundInteger getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(BoundInteger currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void move() {
        if(direction == Direction.EAST) {
            currentPosition.validateX(1);
            currentPosition.incrementX();
        } else if(direction == Direction.WEST) {
            currentPosition.validateX(-1);
            currentPosition.decrementX();
        } else if(direction == Direction.NORTH) {
            currentPosition.validateY(1);
            currentPosition.incrementY();
        } else if(direction == Direction.SOUTH) {
            currentPosition.validateY(-1);
            currentPosition.decrementY();
        }
    }

    @Override
    public String toString() {
        return  currentPosition + "," + direction;
    }
}

