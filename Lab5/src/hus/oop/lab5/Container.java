package hus.oop.lab5;

public class Container {

    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Container(int x, int y, int width, int height) {
        this.x1 = x;
        this.y1 = y;
        this.x2 = x + width - 1;
        this.y2 = y + height - 1;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public boolean collidesWith(Ball ball) {

        if (ball.getX() - ball.getRadius() <= x1 ||
                ball.getX() + ball.getRadius() >= x2 ||
                ball.getY() - ball.getRadius() <= y1 ||
                ball.getY() + ball.getRadius() >= y2) {

            if (ball.getX() - ball.getRadius() <= x1) {
                ball.reflectHorizontal();
            } else if (ball.getX() + ball.getRadius() >= x2) {
                ball.reflectHorizontal();
            }

            if (ball.getY() - ball.getRadius() <= y1) {
                ball.reflectVertical();
            } else if (ball.getY() + ball.getRadius() >= y2) {
                ball.reflectVertical();
            }

            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return String.format("Container[(%d,%d), (%d,%d)]", x1, y1, x2, y2);
    }
}