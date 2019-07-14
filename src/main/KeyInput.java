package main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private Handler handler;

    public KeyInput(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void keyPressed(KeyEvent e) {

        char c = e.getKeyChar();
        switch (c){
            case 'w':
                handler.getById(ID.Player).setVelY(5);
                break;
            case 's':
                handler.getById(ID.Player).setVelY(-5);
                break;
            case 'a':
                handler.getById(ID.Player).setVelX(-5);
                break;
            case 'd':
                handler.getById(ID.Player).setVelX(5);
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        char c = e.getKeyChar();
        switch (c){
            case 'w':
                handler.getById(ID.Player).setVelY(0);
                break;
            case 's':
                handler.getById(ID.Player).setVelY(0);
                break;
            case 'a':
                handler.getById(ID.Player).setVelX(0);
                break;
            case 'd':
                handler.getById(ID.Player).setVelX(0);
                break;
        }
    }
}
