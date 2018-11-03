package Items;

import com.wc.bestgame.Handler;
import gfx.gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by wc_an on 20-May-17.
 */
public class Item {

    //HANDLER

    public static Item[] items=new Item[256];
    public static Item woodItem=new Item(Assets.wood,"Wood",0);
    public static Item treeItem=new Item(Assets.disposableTree,"Stone",1);



    public static final int itemWidth=24,itemHeight=24,PICKED_UP=-1;

    protected Handler handler;
    protected BufferedImage texture;
    protected String itemName;
    protected final int id;
    protected int x,y,count;
    protected Rectangle bounds;
    protected boolean pickedUp=false;


    public Item(BufferedImage texture,String itemName,int id){

        this.texture=texture;
        this.itemName=itemName;
        this.id=id;
        count=1;
        bounds=new Rectangle(x+30,y+40,itemWidth,itemHeight);
        items[id]=this;


    }



    public void tick(){
        if(handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0f,0f).intersects(bounds)){
           pickedUp=true;
           handler.getWorld().getEntityManager().getPlayer().getInventory().addItem(this);
        }
    }
    public void render(Graphics g, int x, int y){
            g.drawImage(texture,x,y,64,64,null);
    }

    public void render(Graphics g){
    if(handler==null)
        return;
        render(g,(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()));

    }

    public void setPosition(int x,int y){
        this.x=x;
        this.y=y;
        bounds.x=x;
        bounds.y=y;
    }

    public Item createNew(int x,int y){

        Item i=new Item(texture,itemName,id);
        i.setPosition(x,y);
        return i;
    }
    public Item createNew(int count){

        Item i=new Item(texture,itemName,id);
        setPickedUp(true);
        i.setCount(count);
        return i;
    }

    //GETTERS SETTERS


    public void setPickedUp(boolean pickedUp) {
        this.pickedUp = pickedUp;
    }

    public boolean isPickedUp() {
        return pickedUp;
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public BufferedImage getTexture() {
        return texture;
    }

    public void setTexture(BufferedImage texture) {
        this.texture = texture;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
