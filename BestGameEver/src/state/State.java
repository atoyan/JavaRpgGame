package state;

import com.wc.bestgame.Game;
import com.wc.bestgame.Handler;
import world.World;

import java.awt.*;

/**
 * Created by wc_an on 5/5/2017.
 */
public abstract class State {

    public static State currentState = null;
    protected Handler handler;
    protected Game game;
    protected World world;
    public State(Handler handler, World world) {
        this.handler = handler;
        this.world = world;
    }

    public static State getState() {

        return currentState;
    }

    public static void setState(State state) {

        currentState = state;
    }

    public abstract void tick();

    public abstract void render(Graphics g);


}
