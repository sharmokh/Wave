package main;

import java.awt.*;

public class BaseEnemy extends GameObject {

    public BaseEnemy(int x, int y, ID id) {
        super(x, y, id);
        velX = 3;
        velY = 3;
    }

    @Override
    public void tick() {
        this.x += velX;
        this.y += velY;
        if (x < 0 || x > Game.WIDTH - 16) {
            velX *= -1;
        }
        if (y < 0 || y > Game.HEIGHT - 32) {
            velY *= -1;
        }
    }

    @Override
    public void render(Graphics graphic) {
        graphic.setColor(Color.ORANGE);
        graphic.fillOval(x, y, 16, 16);
    }
}
