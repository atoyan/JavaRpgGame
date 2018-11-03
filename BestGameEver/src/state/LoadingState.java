package state;

import com.wc.bestgame.Handler;
import gfx.gfx.Animation;
import gfx.gfx.Assets;
import gfx.gfx.UIManager;
import world.World;

import java.awt.*;

/**
 * Created by wc_an on 5/5/2017.
 */
public class LoadingState extends State {
    private UIManager uiManager;
    private Animation animation;
    private long startTime, finalTime;
    private World world;

    public LoadingState(Handler handler, World world) {
        super(handler, world);
        this.world = world;
        animation = new Animation(200, Assets.loadingScreen);
        startTime = System.currentTimeMillis();
        finalTime = System.currentTimeMillis();


    }


    @Override
    public void tick() {
        animation.tick();
        finalTime = System.currentTimeMillis();
        if (handler.getWorld().getWorldName()=="worldOne"&&finalTime - startTime > 4000) {
            startTime = System.currentTimeMillis();
            handler.getGame().setWorldOneIsActivated(false);
            handler.getGame().setWorldTwoIsActivated(true);
            handler.getWorld().getEntityManager().getPlayer().setX(100);
            handler.getWorld().getEntityManager().getPlayer().setY(100);

            State.setState(handler.getGame().gameState);

        }

       else if (handler.getWorld().getWorldName()=="worldTwo"&&finalTime - startTime > 4000) {
            startTime = System.currentTimeMillis();
            handler.getGame().setWorldOneIsActivated(true);
            handler.getGame().setWorldTwoIsActivated(false);
            handler.getWorld().getEntityManager().getPlayer().setX(850);
            handler.getWorld().getEntityManager().getPlayer().setY(855);

            State.setState(handler.getGame().gameState);

        }else{return;}
    }

    @Override
    public void render(Graphics g) {


        g.drawImage(animation.getCurrentFrame(), 0, 0, 1024, 768, null);

    }


}
