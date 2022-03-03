package com.platformer;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.platformer.world.GameMap;
import com.platformer.world.TiledGameMap;

public class Main extends ApplicationAdapter {
	OrthographicCamera camera;

	SpriteBatch batch;

	private GameMap map;
	private Player player;

	@Override
	public void create () {
		//Enable debug logging
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		//Create a camera going from -50 50
		camera = new OrthographicCamera();
		camera.setToOrtho(false);
		//Smaller numbers = closer
		camera.update();

		map = new TiledGameMap();
		batch = new SpriteBatch();
		player = new Player(0,0);
	}

	@Override
	public void render () {
		ScreenUtils.clear(.15f, .15f, .15f, 1);
		map.render(camera);
		player.update();

		if(Gdx.input.isTouched()) {
			camera.translate(-Gdx.input.getDeltaX(), Gdx.input.getDeltaY());
			camera.update();
		}
//		if(Gdx.input.justTouched()){
//			Vector3 worldPos = camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
//			System.out.println(map.getTile(0, worldPos.x, worldPos.y));
//		}
		batch.begin();
		Vector3 playerPos = camera.project(new Vector3(player.x, player.y, 0));
		batch.draw(player.getSprite(), playerPos.x, playerPos.y);
		batch.end();
	}


	@Override
	public void dispose () {
		batch.dispose();
	}
}
