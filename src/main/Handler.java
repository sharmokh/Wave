package main;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class Handler {

    List<GameObject> objects = new LinkedList<>();

    public void tick() {
        for (GameObject object : objects) {
            object.tick();
        }
    }

    public void render(Graphics graphic) {
        for (GameObject object : objects) {
            object.render(graphic);
        }
    }

    public void addObject(GameObject object) {
        this.objects.add(object);
    }

    public void removeObject(GameObject object) {
        this.objects.remove(object);
    }

}
