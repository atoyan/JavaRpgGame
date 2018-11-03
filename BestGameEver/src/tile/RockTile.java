package tile;

import gfx.gfx.Assets;

/**
 * Created by wc_an on 08-May-17.
 */
public class RockTile extends Tile {

    public RockTile(int id){
        super(Assets.stone,id);

    }
    @Override
    public boolean isSolid(){
        return true;
    }

}
