package entity;

import com.wc.bestgame.Handler;

/**
 * Created by wc_an on 18-May-17.
 */
public abstract class StaticEntity extends Entity{

    public StaticEntity(Handler handler, float x , float y , int width, int height){
        super(handler,x,y,width,height);

    }
}
