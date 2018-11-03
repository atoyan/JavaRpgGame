package tile;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by wc_an on 08-May-17.
 */



public class Tile {

    public static Tile[] tiles=new Tile[256];
    public static Tile grassTile=new GrassTile(0);
    public static Tile dirtTile=new DirtTile(1);
    public static Tile rockTile=new RockTile(2);


    public static final int TILE_WIDTH=48;
    public static final int TILE_HEIGHT=48;
    protected final int id;
    protected BufferedImage texture;

    public Tile(BufferedImage texture,int id){
    this.id=id;
    this.texture=texture;

    tiles[id]=this;
    }
    public boolean isSolid(){
        return false;
    }

    public int Id() {
        return id;
    }

    public void tick(){


    }

    public void render(Graphics g,int x , int y){

        g.drawImage(texture,x,y,TILE_WIDTH, TILE_HEIGHT,null);

    }


}
