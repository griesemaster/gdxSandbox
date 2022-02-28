package com.platformer.world;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.Logger;
import java.util.Optional;

public class TiledGameMap extends GameMap{

    private final Logger log = new Logger(this.getClass().getName(), Logger.DEBUG);
    private final TiledMap tiledMap;
    private final OrthogonalTiledMapRenderer mapRenderer;


    public TiledGameMap(){
        tiledMap = new TmxMapLoader().load("map.tmx");
        mapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
    }

    @Override
    public void render(OrthographicCamera camera) {
        mapRenderer.setView(camera);
        mapRenderer.render();
    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void dispose() {
        tiledMap.dispose();
        mapRenderer.dispose();
    }

    @Override
    public Tile getTile(int layer, int x, int y) {
        Optional<TiledMapTileLayer.Cell> cell = Optional.ofNullable(((TiledMapTileLayer) tiledMap.getLayers().get(layer)).getCell(x, y));
        if(cell.isPresent()){
            Optional<TiledMapTile> tile = Optional.ofNullable(cell.get().getTile());
            if(tile.isPresent()){
                return Tile.getTile(tile.get().getId());
            }
            else {
                log.debug(String.format("Cell contains no tile at %d, %d", x, y));
            }
        }
        else {
            log.debug(String.format("Failed to locate cell at %d, %d", x, y));
        }
        return null;
    }

    @Override
    public int getWidth() {
        return (int) tiledMap.getProperties().get("width");
    }

    @Override
    public int getHeight() {
        return (int) tiledMap.getProperties().get("height");
    }

    @Override
    public int getLayers() {
        return tiledMap.getLayers().size();
    }

    /**
     * Used to print all the map properties for debug n stuff
     */
    public void printProperties(){
        tiledMap.getProperties().getKeys().forEachRemaining(key -> System.out.println(key + " " + tiledMap.getProperties().get(key)));
    }
}
