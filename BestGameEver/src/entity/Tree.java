package entity;

import com.wc.bestgame.Handler;
import gfx.gfx.Assets;
import tile.Tile;

import java.awt.*;

/**
 * Created by wc_an on 18-May-17.
 */
public class Tree extends StaticEntity {

    public Tree(Handler handler,float x,float y){
        super(handler,x,y, Tile.TILE_WIDTH*2,Tile.TILE_HEIGHT*2);
        bounds.x=10;
        bounds.y=(int)(height/1.5f);
        bounds.width=width-50;
        bounds.height=(int)(height-90);
        immune=true;


    }


    @Override
    public void tick(){


    }
    @Override
    public void die(){

    }

    @Override
    public  void render(Graphics g){
        g.drawImage(Assets.tree,(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),width,height,null);
    }
}
