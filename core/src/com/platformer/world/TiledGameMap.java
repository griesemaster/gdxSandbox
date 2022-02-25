package com.platformer.world;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthoCachedTiledMapRenderer;

public class TiledGameMap extends GameMap{

    private final TiledMap tiledMap;
    private final OrthoCachedTiledMapRenderer mapRenderer;


    public TiledGameMap(){
        tiledMap = new TmxMapLoader().load("map.tmx");
        mapRenderer = new OrthoCachedTiledMapRenderer(tiledMap);
    }

    @Override
    public void render() {

    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void dispose() {

    }

    @Override
    public Tile getTile(int layer, int x, int y) {
        return null;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public int getLayers() {
        return 0;
    }
}
