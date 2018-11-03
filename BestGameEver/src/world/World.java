package world;

import Items.ItemManager;
import com.wc.bestgame.Handler;
import entity.*;
import tile.Tile;
import utils.Utils;

import java.awt.*;



/**
 * Created by wc_an on 09-May-17.
 */
public class World {
    private int width, height;
    private Handler handler;
    private int spawnX, spawnY;
    private int[][] tiles;
    private String worldName;
    //Entities
    private EntityManager entityManager;
    //Items
    private ItemManager itemManager;

    public World(Handler handler, String path,String worldName) {
        this.handler = handler;
        this.worldName=worldName;
        entityManager=new EntityManager(handler,new Player(handler,getSpawnX(),getSpawnY()));
        itemManager=new ItemManager(handler);
        if(worldName=="worldOne") {

            entityManager.addEntity(new Tree(handler, 40, 250));
            entityManager.addEntity(new Tree(handler, 40, 300));
            entityManager.addEntity(new Tree(handler, 40, 350));
            entityManager.addEntity(new Tree(handler, 40, 400));
            entityManager.addEntity(new Tree(handler, 40, 450));
            entityManager.addEntity(new DisposableTree(handler, 100, 750));
            entityManager.addEntity(new DisposableTree(handler, 150, 750));
            entityManager.addEntity(new DisposableTree(handler, 200, 750));
            entityManager.addEntity(new DisposableTree(handler, 250, 750));
            entityManager.addEntity(new DisposableTree(handler, 300, 750));
            entityManager.addEntity(new DisposableTree(handler, 350, 750));
            entityManager.addEntity(new DisposableTree(handler, 400, 750));
        }
        else if(worldName=="worldTwo"){

            entityManager.addEntity(new DisposableTree(handler, 150, 750));
        }
        loadWorld(path);

        entityManager.getPlayer().setX(getSpawnX());
        entityManager.getPlayer().setY(getSpawnY());

    }

    public int getSpawnX() {
        return spawnX;
    }

    public int getSpawnY() {
        return spawnY;
    }

    public void tick() {
        itemManager.tick();
        entityManager.tick();
    }

    public void render(Graphics g) {
        int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILE_WIDTH);
        int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILE_WIDTH + 1);
        int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILE_HEIGHT);
        int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILE_HEIGHT + 1);


        for (int y = yStart; y < yEnd; y++) {
            for (int x = xStart; x < xEnd; x++) {

                getTile(x, y).render(g, (int) (x * Tile.TILE_WIDTH - handler.getGameCamera().getxOffset()), (int) (y * Tile.TILE_HEIGHT - handler.getGameCamera().getyOffset()));
            }

        }
        //item
        itemManager.render(g);
        //entity
        entityManager.render(g);
    }


    public Tile getTile(int x, int y) {
        if (x < 0 || y < 0 || x >= width || y >= height) {
            return Tile.grassTile;

        }
        Tile t = Tile.tiles[tiles[x][y]];
        if (t == null) {
            return Tile.dirtTile;
        }
        return t;
    }

    private void loadWorld(String path) {
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");

        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        spawnX = Utils.parseInt(tokens[2]);
        spawnY = Utils.parseInt(tokens[3]);

        tiles = new int[width][height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tiles[x][y] = Utils.parseInt(tokens[((x + y * width) + 4)]);
            }

        }
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public String getWorldName() {
        return worldName;
    }

    public ItemManager getItemManager() {
        return itemManager;
    }

    public void setItemManager(ItemManager itemManager) {
        this.itemManager = itemManager;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
