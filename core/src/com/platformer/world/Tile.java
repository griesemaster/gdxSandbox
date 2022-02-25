package com.platformer.world;

import com.badlogic.gdx.graphics.Texture;

public enum Tile {
    air(""),
    ground("ground.png");

    public static final int TILE_SIZE = 16;

    private final Texture sprite;

    private Tile(String aSpriteFilePath){
        sprite = new Texture(aSpriteFilePath);
    }

    public Texture getSprite() {
        return sprite;
    }
}
