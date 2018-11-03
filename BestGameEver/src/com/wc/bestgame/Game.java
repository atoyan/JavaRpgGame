package com.wc.bestgame;

import display.Display;
import gfx.gfx.Assets;
import gfx.gfx.GameCamera;
import gfx.gfx.SpriteSheet;
import org.w3c.dom.css.Rect;
import state.GameState;
import state.LoadingState;
import state.MenuState;
import state.State;
import world.World;
import world.WorldManager;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

/**
 * Created by wc_an on 5/4/2017.
 */
public class Game implements Runnable {


    public boolean running = false;
    public String title;
    Thread thread;
    private int width, height;
    private Display display;

    private BufferStrategy bs;
    private Graphics g;
    private BufferedImage testImage;
    private SpriteSheet sheet;
    private BufferedImage test2;
    private int x = 0;


    //STATES
    public State gameState;
    public State menuState;
    public State loadingState;

    //KeyManager
    private MouseManager mouseManager;
    private KeyManager keyManager;
    private GameCamera gameCamera;
    private boolean worldOneIsActivated=false;
    private boolean worldTwoIsActivated=false;
    //HANDLER
    private Handler handler;
    //WorldManager
    private WorldManager worldManager;


    public Game(String title, int width, int height) {

        this.width = width;
        this.height = height;
        this.title = title;
        keyManager = new KeyManager();
        mouseManager = new MouseManager();
        worldManager=new WorldManager();

    }

    private void init() {

        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);
        Assets.init();


        handler = new Handler(this);
        worldManager.addWorld(new World(handler, "./res/worldsToLoad/worldOne.txt", "worldOne"));
        worldManager.addWorld(new World(handler, "./res/worldsToLoad/worldTwo.txt", "worldTwo"));
        gameCamera = new GameCamera(handler, 0, 0);
        gameState = new GameState(handler,handler.getWorld());
        menuState = new MenuState(handler,null);
        loadingState=new LoadingState(handler,handler.getWorld());
        State.setState(menuState);



    }

    private void tick() {
        keyManager.tick();
        if (State.getState() != null) {


            State.getState().tick();
        }


    }

    private void render() {

        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {

            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //clear Screen
        g.clearRect(0, 0, 1024, 768);
        //Draw Here

        if (State.getState() != null) {

            State.getState().render(g);
        }

        //End Draw
        bs.show();
        g.dispose();

    }

    public void run() {
        init();
        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        int ticks = 0;
        long timer = 0;
        long now;
        long lastTime = System.nanoTime();

        while (running) {
            //GAME TIME //
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;
            //END TIME//
            if (delta >= 1) {
                tick();
                render();
                ticks++;
                delta--;
            }
            if (timer >= 1000000000) {
                //  System.out.println(ticks);

                ticks = 0;
                timer = 0;

            }
        }
        stop();
    }

    //Camera

    public GameCamera getGameCamera() {
        return gameCamera;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public MouseManager getMouseManager() {
        return mouseManager;
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }

    public WorldManager getWorldManager() {
        return worldManager;
    }

    public synchronized void start() {
        if (running == true) {
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();

    }

    public synchronized void stop() {
        if (running == false) {

            return;
        }
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public boolean isWorldOneIsActivated() {
        return worldOneIsActivated;
    }

    public void setWorldOneIsActivated(boolean worldOneIsActivated) {
        this.worldOneIsActivated = worldOneIsActivated;
    }

    public boolean isWorldTwoIsActivated() {
        return worldTwoIsActivated;
    }

    public void setWorldTwoIsActivated(boolean worldTwoIsActivated) {
        this.worldTwoIsActivated = worldTwoIsActivated;
    }
}
