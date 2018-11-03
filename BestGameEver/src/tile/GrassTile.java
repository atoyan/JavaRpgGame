package tile;

import gfx.gfx.Assets;

import java.awt.image.BufferedImage;

/**
 * Created by wc_an on 08-May-17.
 */
public class GrassTile extends Tile{
        protected int id;

    public GrassTile(int id){
        super(Assets.grass,id);
        this.id=id;


    }

}
