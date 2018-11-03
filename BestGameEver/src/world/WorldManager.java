package world;

import java.util.ArrayList;

/**
 * Created by wc_an on 24-May-17.
 */
public class WorldManager {
    private World world;
    private ArrayList<World> worldsList;

    public WorldManager(){
        worldsList=new ArrayList<>();

    }

    public World getWorldFromList(int index) {
        return worldsList.get(index);
    }
    public void addWorld(World world){
        worldsList.add(world);
    }

}
