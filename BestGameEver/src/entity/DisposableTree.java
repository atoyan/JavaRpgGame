package entity;

import Items.Item;
import com.wc.bestgame.Handler;
import gfx.gfx.Assets;
import tile.Tile;

import java.awt.*;

/**
 * Created by wc_an on 18-May-17.
 */
public class DisposableTree extends StaticEntity {

    public DisposableTree(Handler handler, float x, float y){
        super(handler,x,y, Tile.TILE_WIDTH*2,Tile.TILE_HEIGHT*2);
        bounds.x=10;
        bounds.y=(int)(height/1.5f);
        bounds.width=width-50;
        bounds.height=(int)(height-90);
        immune=false;


    }


    @Override
    public void tick(){


    }
    @Override
    public void die(){
        handler.getWorld().getItemManager().addItem(Item.woodItem.createNew((int)x,(int)y));

    }

    @Override
    public  void render(Graphics g){
        g.drawImage(Assets.disposableTree,(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),width-15,height+5,null);
    }
}
