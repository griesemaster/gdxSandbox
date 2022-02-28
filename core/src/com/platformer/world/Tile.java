package com.platformer.world;

import java.util.HashMap;

public enum Tile {
    GRASS(1, true, "Grass"),
    DIRT(2, true, "Dirt"),
    AIR(3, false, "Air"),
    LAVA(4, true, "Lava"),
    CLOUD(5, true, "Cloud"),
    STONE(6, true, "Stone");

    public static final int TILE_SIZE = 16;
    public static final HashMap<Integer, Tile> tileMap = new HashMap<>();
    private final int id;
    private final boolean collide;
    private final String name;

    Tile(int id, boolean collide, String name){
        this.id = id;
        this.collide = collide;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public boolean isCollide() {
        return collide;
    }

    public String getName() {
        return name;
    }

    public static Tile getTile(int id){
        return tileMap.get(id);
    }

    /*
      Creates a lookup table for all tiles to be indexed by their id value
     */
    static {
        for(Tile tile : Tile.values()){
            tileMap.put(tile.id, tile);
        }
    }
}
