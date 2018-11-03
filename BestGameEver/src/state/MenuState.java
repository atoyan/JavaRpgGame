package state;

import com.wc.bestgame.Game;
import com.wc.bestgame.Handler;
import gfx.gfx.Assets;
import gfx.gfx.ClickListener;
import gfx.gfx.UIImageButton;
import gfx.gfx.UIManager;
import world.World;

import java.awt.*;

/**
 * Created by wc_an on 5/5/2017.
 */
public class MenuState extends State {
private UIManager uiManager;
    public MenuState(Handler handler, World world){
        super(handler,null);
        uiManager=new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager);
        uiManager.addObject(new UIImageButton(400, 300, 256, 128, Assets.start, new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null);
                handler.setWorld(new World(handler, "./res/worldsToLoad/worldOne.txt", "worldOne"));
                State.setState(handler.getGame().gameState);
            }
        }));
    }


    @Override
    public void tick() {
        uiManager.tick();
    }

    @Override
    public void render(Graphics g) {

            uiManager.render(g);

    }


}
