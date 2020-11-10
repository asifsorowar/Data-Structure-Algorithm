package com.asifsorowar.HashMap;

import java.util.LinkedList;

public class HashTable {
    private class Entity {
        private int key;
        private String value;

        private Entity(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    // LinkedList
    // [null, null, null, null, null]

    private LinkedList<Entity>[] entities = new LinkedList[5];

    public void put(int key, String value) {
        int index = hash(key);

        if (entities[index] == null)
            entities[index] = new LinkedList<>();

        for (var entity : entities[index]) {
            if (entity.key == key) {
                entity.value = value;
                return;
            }
        }
        var entity = new Entity(key, value);
        entities[index].addLast(entity);

    }

    public String get(int key) {
        int index = hash(key);
        var bucket = entities[index];

        if (bucket != null) {
            for (var entity : bucket) {
                if (entity.key == key)
                    return entity.value;
            }
        }
        return null;
    }

    public void remove(int key) {
        int index = hash(key);
        var bucket = entities[index];

        if (bucket == null)
            throw new IllegalStateException();

        for (var entity : bucket) {
            if (entity.key == key) {
                bucket.remove(entity);
                return;
            }
        }
        throw new IllegalStateException();
    }



    private int hash(int key) {
        return key % entities.length;
    }
}
