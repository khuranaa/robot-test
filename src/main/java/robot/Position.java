package robot;

public class Position {
    private BoundInteger axis;

    private Direction direction;

    public Position() {
    }

    public Position(BoundInteger currentPosition, Direction direction) {
        this.axis = currentPosition;
        this.direction = direction;
    }

    public BoundInteger getAxis() {
        return axis;
    }

    public void setAxis(BoundInteger axis) {
        this.axis = axis;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void move() {
        if(direction == Direction.EAST) {
            axis.incrementX();
        } else if(direction == Direction.WEST) {
            axis.decrementX();
        } else if(direction == Direction.NORTH) {
            axis.incrementY();
        } else if(direction == Direction.SOUTH) {
            axis.decrementY();
        }
    }

    @Override
    public String toString() {
        return  axis + "," + direction;
    }
}

