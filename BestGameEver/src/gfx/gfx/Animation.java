package gfx.gfx;

import java.awt.image.BufferedImage;

/**
 * Created by wc_an on 18-May-17.
 */
public class Animation {

    private int speed,index;
    private BufferedImage[]frames;
    private long lastTime,timer;

    public Animation(int speed,BufferedImage[]frames){

        this.speed=speed;
        this.frames=frames;
        index=0;
        lastTime=System.currentTimeMillis();
    }

    public void tick(){

    timer+=System.currentTimeMillis()-lastTime;
    lastTime=System.currentTimeMillis();

    if(timer>speed){
        index++;
        timer=0;
        if(index>=frames.length){
            index=0;
        }
    }

    }


    public BufferedImage getCurrentFrame(){
        return frames[index];
    }

    public int index(){
        return index;
    }

    public BufferedImage[] getFrames() {
        return frames;
    }
}
