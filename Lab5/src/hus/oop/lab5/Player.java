package hus.oop.lab5;

import java.util.Scanner;

public class Player {
    private final int number;
    private float x;
    private float y;
    private float z = 0.0f;

    public Player(int number, float x, float y) {
        this.number = number;
        this.x = x;
        this.y = y;
        z = 0.0f;
    }

    public void move(float xDisp, float yDisp) {
        x += xDisp;
        y += yDisp;
    }

    public void jump(float zDisp) {
        z += zDisp;
    }

    public boolean near(BallPlayer ball) {
        float xDiff = x - ball.getX();
        float yDiff = y - ball.getY();
        float zDiff = z - ball.getZ();
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff + zDiff * zDiff) < 8;
    }

    public void kick(BallPlayer ball) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Kick the ball to: ");
        ball.setXYZ(sc.nextFloat(), sc.nextFloat(), sc.nextFloat());
    }
}

