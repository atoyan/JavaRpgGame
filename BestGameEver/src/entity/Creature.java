package entity;

import com.wc.bestgame.Handler;
import tile.Tile;

/**
 * Created by wc_an on 5/5/2017.
 */
public abstract class Creature extends Entity {


    public static final float DEFAULT_SPEED = 3.0f;
    public static final int DEFAULT_CREATURE_WIDTH = 64;
    public static final int DEFAULT_CREATURE_HEIGHT = 64;
    protected float xMove, yMove;
    protected float speed;

    public Creature(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);

        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;

    }


    public void move() {
        if(!checkEntityCollision(xMove,0))
        moveX();
        if(!checkEntityCollision(0,yMove))
        moveY();

    }

    public void moveX() {
        if (xMove > 0) {//move right
            int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILE_WIDTH;
            if (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILE_HEIGHT) && (!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT))) {
                x += xMove;
            }
            else{
                x=tx*Tile.TILE_WIDTH-bounds.x-bounds.width-1;

            }
        } else if (xMove < 0) {//move left
            int tx = (int) (x + xMove + bounds.x) / Tile.TILE_WIDTH;
            if (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILE_HEIGHT) && (!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT))) {
                x += xMove;
            }
            else{
                x=tx*Tile.TILE_WIDTH+Tile.TILE_WIDTH-bounds.x;

            }
        }

    }
    public void moveY() {
       if(yMove<0){//move Up
        int ty=(int)(y+yMove+bounds.y)/Tile.TILE_HEIGHT;

        if(!collisionWithTile((int)(x+bounds.x)/Tile.TILE_WIDTH,ty)&&
                !collisionWithTile((int)(x+bounds.x+bounds.width)/Tile.TILE_WIDTH,ty)){
         y+=yMove;
           }else{
            y=ty*Tile.TILE_HEIGHT+Tile.TILE_HEIGHT-bounds.y;
        }
       }
       else if(yMove>0){//move Down
           int ty=(int)(y+yMove+bounds.y+bounds.height)/Tile.TILE_HEIGHT;

           if(!collisionWithTile((int)(x+bounds.x)/Tile.TILE_WIDTH,ty)&&
                   !collisionWithTile((int)(x+bounds.x+bounds.width)/Tile.TILE_WIDTH,ty)){
               y+=yMove;
           }
           else{
               y=ty*Tile.TILE_HEIGHT-bounds.y-bounds.height-1;
           }
       }
    }

    protected boolean collisionWithTile(int x, int y) {
        return handler.getWorld().getTile(x, y).isSolid();
    }

    //GETTERS SETTERS

    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }






    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }


}
