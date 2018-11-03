package com.wc.bestgame;

import gfx.gfx.GameCamera;
import world.World;
import world.WorldManager;

/**
 * Created by wc_an on 11-May-17.
 */
public class Handler {

    private Game game;
    private World world;


    public Handler(Game game) {

        this.game = game;

    }

    public int getWidth() {
        return game.getWidth();

    }

    public int getHeight() {
        return game.getHeight();

    }

    public GameCamera getGameCamera(){
        return game.getGameCamera();
    }

    public KeyManager getKeyManager() {
        return game.getKeyManager();
    }
    public MouseManager getMouseManager(){return  game.getMouseManager();}

    public Game getGame() {
        return game;
    }



    public void setGame(Game game) {
        this.game = game;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }
}
