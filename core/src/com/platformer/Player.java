package com.platformer;

import com.badlogic.gdx.graphics.Texture;

public class Player {
    private Texture sprite;
    private final int moveSpeed = 0;
    public int x, y;

    public Player(int x, int y){
        sprite = new Texture("char.png");
        this.x = x;
        this.y = y;
    }

    public Texture getSprite() {
        return sprite;
    }

    public void dispose(){
        sprite.dispose();
    }

    @Override
    public String toString(){
        return x + " " + y;
    }
}
