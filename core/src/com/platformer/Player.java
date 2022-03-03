package com.platformer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;

public class Player {
    private final Texture sprite;
    public int x, y;

    public Player(int x, int y){
        sprite = new Texture(new FileHandle("newChar.png"));
        this.x = x;
        this.y = y;
    }

    public Texture getSprite() {
        return sprite;
    }

    public void update(){
        if(Gdx.input.isKeyJustPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.D)) x += 1;
        if(Gdx.input.isKeyJustPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.A)) x -= 1;
        if(Gdx.input.isKeyJustPressed(Input.Keys.W) || Gdx.input.isKeyPressed(Input.Keys.W)) y += 1;
        if(Gdx.input.isKeyJustPressed(Input.Keys.S) || Gdx.input.isKeyPressed(Input.Keys.S)) y -= 1;
    }

    public void dispose(){
        sprite.dispose();
    }

    @Override
    public String toString(){
        return x + " " + y;
    }
}
