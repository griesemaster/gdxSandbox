package com.platformer;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.platformer.world.Tile;

public class Main extends ApplicationAdapter {
	OrthographicCamera camera;

	SpriteBatch batch;

	private final int levelHeight = 16;
	private final int levelWidth = 64;

	private final Array<String> level = new Array<>();

	Player P1;



	@Override
	public void create () {
		//Create a camera going from -50 50
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 256, 256);
		camera.update();

		batch = new SpriteBatch();
		P1 = new Player(13 ,15);
		System.out.println(level.size);
	}

	@Override
	public void render () {
		ScreenUtils.clear(.15f, .15f, .15f, 1);


//		//Draw all level tiles and player
//		batch.begin();
//		batch.setProjectionMatrix(camera.combined);
//		Vector3 drawCoordinate;
//		for(int x = 0; x < levelWidth; x++){
//			for(int y = 0; y < levelHeight; y++){
//				Tile tile = getTileType(x, y);
//				drawCoordinate = camera.project(new Vector3(x, y, 0));
//				batch.draw(tile.getSprite(), drawCoordinate.x, drawCoordinate.y);
//			}
//		}
//		drawCoordinate = camera.project(new Vector3(P1.x, P1.y, 0));
//		batch.draw(P1.getSprite(), drawCoordinate.x, drawCoordinate.y);
//		batch.end();
//
//	}
//
//	private Tile getTileType(int x, int y){
//		if(x < 0 || x > levelWidth - 1 || y < 0 || y > levelHeight - 1)
//			throw new IllegalStateException(String.format("Attempting to access illegal level coordinate (%d, %d)", x, y));
//		switch(level.get(y).charAt(x)){
//			case '#':
//				return Tile.ground;
//			case '.':
//				return Tile.air;
//			default:
//				throw new IllegalStateException(String.format("Invalid terrain in level char %c at (%d, %d)", level.get(y).charAt(x), x, y));
//		}
	}

	@Override
	public void dispose () {
		batch.dispose();
		P1.dispose();
	}
}
