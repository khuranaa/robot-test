package robot;

public class BoundInteger {
    private int xAxis;
    private int yAxis;

    public BoundInteger(int xAxis, int yAxis) {
        validateX(xAxis);
        validateY(yAxis);
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public void incrementX() {
        validateX(xAxis + 1);
        xAxis++;
    }

    public void decrementX() {
        validateX(xAxis -1);
        xAxis--;
    }

    public void incrementY() {
        validateY(yAxis + 1);
        yAxis++;
    }

    public void decrementY() {
        validateY(yAxis -1);
        yAxis--;
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

    public void validateX(int move) {
        isBound(xAxis + move);
    }

    public void validateY(int move) {
        isBound(yAxis + move);
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