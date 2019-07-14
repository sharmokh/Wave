package main;

import java.awt.*;
import java.util.Random;

public class Player extends GameObject {

    Random random = new Random();

    public Player(int x, int y, ID id) {

        super(x, y, id);
        //velX = random.nextInt(5);
        //velY = random.nextInt(8);

    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        if (x < 0) {
            x = Game.WIDTH;
        }
        if (x > Game.WIDTH) {
            x = 0;
        }
        if (y < 0) {
            y = Game.HEIGHT;
        }
        if (y > Game.HEIGHT) {
            y = 0;
        }
    }

    @Override
    public void render(Graphics graphic) {
        graphic.setColor(Color.red);
        graphic.fillRect(x, y, 32, 32);
    }
}
