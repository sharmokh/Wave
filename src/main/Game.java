package main;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
    private Thread thread;
    private boolean running = false;
    private Handler handler;

    public Game() {
        handler = new Handler();
        handler.addObject(new Player(100, 100, ID.Player));
        handler.addObject(new BaseEnemy(150, 200, ID.Enemy));
        this.addKeyListener(new KeyInput(handler));
        new Window(WIDTH, HEIGHT, "New Game", this);
    }

    public synchronized void start() {

        if (running) return;
        running = true;
        thread = new Thread(this );
        thread.start();
    }

    public synchronized void stop() {

        if (!running) return;
        running = false;
        try {
            thread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {

        // Tracks time before rendering next frame in nanoseconds.
        int framePerSecond = 30;
        double timeBetweenFrames = 1000000000 / framePerSecond;
        double delta = 0;

        // Holds time in nanosecond for current and previous time in loop
        long now;
        long lastTime = System.nanoTime();

        // Verifies frames per second
        // long timer = 0;
        // int frame = 0;

        while (running) {

            // delta tracks amount of time between frames
            // timer tracks number of frames per second
            now = System.nanoTime();
            delta += now - lastTime;
            // timer += now - lastTime;
            lastTime = now;

            // Updates environment and renders screen once every time
            // delta exceeds timeBetweenFrames
            if (delta >= timeBetweenFrames) {
                tick();
                render();
                // frame++;
                delta -= timeBetweenFrames;
            }

            /*
            // Prints frame rate per second
            if (timer > 1000000000) {
                System.out.println("Frames: " + frame);
                timer = 0;
                frame = 0;
            }
            */
        }

        stop();
    }

    private void tick() {
        handler.tick();
    }

    private void render() {

        BufferStrategy bufferStrategy = this.getBufferStrategy();
        if (bufferStrategy == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics graphic = bufferStrategy.getDrawGraphics();
        graphic.setColor(Color.black);
        graphic.fillRect(0,0, WIDTH, HEIGHT);

        handler.render(graphic);

        graphic.dispose();
        bufferStrategy.show();

    }

    public static void main(String args[]) {
        new Game();
    }
}
