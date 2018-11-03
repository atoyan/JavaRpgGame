package gfx.gfx;

import java.awt.image.BufferedImage;

/**
 * Created by wc_an on 5/5/2017.
 */
public class SpriteSheet {

    private BufferedImage sheet;


    public SpriteSheet(BufferedImage sheet){

            this.sheet=sheet;

    }

    public BufferedImage crop(int x,int y, int width,int height){

        return sheet.getSubimage(x,y,height,width);

    }

}
