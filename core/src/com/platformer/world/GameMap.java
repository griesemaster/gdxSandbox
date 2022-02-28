package com.platformer.world;

import com.badlogic.gdx.graphics.OrthographicCamera;

public abstract class GameMap {

    /**
     * Rendering utils
     */
    public abstract void render(OrthographicCamera camera);
    public abstract void update(float deltaTime);
    public abstract void dispose();


    /**
     * Given a layer (foreground or background) get the corresponding tile
     * @param layer desired level layer
     * @param x coordinate of tile x
     * @param y coordinate of tile y
     * @return the type of tile at the requested location
     */
    public Tile getTile(int layer, float x, float y){
        return getTile(layer, (int)(x / Tile.TILE_SIZE), (int)(y / Tile.TILE_SIZE));
    }

    /**
     * Given a layer (foreground or background) get the corresponding tile
     * @param layer desired level layer
     * @param x coordinate of tile x
     * @param y coordinate of tile y
     * @return the type of tile at the requested location
     */
    public abstract Tile getTile(int layer, int x, int y);

    /**
     * Interfacing utils for getting data about the contained map
     */
    public abstract int getWidth();
    public abstract int getHeight();
    public abstract int getLayers();

}
