package robot;

public class BoundInteger {
    private int xAxis;
    private int yAxis;

    public BoundInteger(int xAxis, int yAxis) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public void incrementX() {
        validate(xAxis++);
    }

    public void decrementX() {
        validate(xAxis--);
    }

    public void incrementY() {
        validate(yAxis++);
    }

    public void decrementY() {
        validate(xAxis--);
    }

    public int getxAxis() {
        return xAxis;
    }

    public void setxAxis(int xAxis) {
        this.xAxis = xAxis;
    }

    public int getyAxis() {
        return yAxis;
    }

    public void setyAxis(int yAxis) {
        this.yAxis = yAxis;
    }

    public void validate(int axis) {
        isBound(axis);
        isBound(axis);
    }

    private void isBound(int axis) {
        if(axis < 0 || axis > 5) {
            throw new IllegalArgumentException("axis value is  invalid, has to be between 1 and 5");
        }
    }

    @Override
    public String toString() {
        return xAxis + "," + yAxis;
    }
}