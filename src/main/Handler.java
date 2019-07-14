package main;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Handler {

    private Map<ID, GameObject> objects = new HashMap<>();

    public void tick() {
        for (GameObject object : objects.values()) {
            object.tick();
        }
    }

    public void render(Graphics graphic) {
        for (GameObject object : objects.values()) {
            object.render(graphic);
        }
    }

    public GameObject getById(ID id) { return objects.get(id); }

    public void addObject(GameObject object) {
        this.objects.put(object.getId(), object);
    }

    public void removeObject(GameObject object) {
        this.objects.remove(object.getId());
    }

}
