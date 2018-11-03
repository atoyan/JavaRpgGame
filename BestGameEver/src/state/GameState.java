package state;

import com.wc.bestgame.Handler;
import entity.Player;
import entity.Tree;
import world.World;

import java.awt.*;

/**
 * Created by wc_an on 5/5/2017.
 */
public class GameState extends State {
    private Player player;
    private World world, world1, world2;
    private Tree tree;
    private Rectangle worldOneExitBounds;
    private Rectangle worldTwoExitBounds;
    private MenuState menuState;
    private GameState gameState;
    private LoadingState loadingState;
    private boolean worldOneActivated = false;
    private boolean worldTwoActivated = false;
    private long startTime;
    private long currentTime;


    public GameState(Handler handler, World world) {
        super(handler, world);
        this.world = world;
        handler.setWorld(handler.getWorld());
        worldOneExitBounds = new Rectangle(0, 0, 20, 96 + 48);
        worldTwoExitBounds = new Rectangle(970, 845, 20, 96 + 48);
        world1 = new World(handler, "./res/worldsToLoad/worldOne.txt", "worldOne");
        world2 = new World(handler, "./res/worldsToLoad/worldTwo.txt", "worldTwo");
        // player=new Player(handler,world.getSpawnX(),world.getSpawnY());


        // game.getGameCamera().move(100,100);

    }

    @Override
    public void tick() {
        handler.getWorld().tick();
        System.out.println(" X : " + handler.getWorld().getEntityManager().getPlayer().getX() + " Y : " + handler.getWorld().getEntityManager().getPlayer().getY());

        if (handler.getWorld().getWorldName() == "worldOne") {
            if (handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0, 0).intersects(worldOneExitBounds))
            //  if (handler.getWorld().getEntityManager().getPlayer().getX() <= 20 && handler.getWorld().getEntityManager().getPlayer().getY() <= 95)
            {
                handler.setWorld(handler.getGame().getWorldManager().getWorldFromList(1));
                State.setState(handler.getGame().loadingState);



            }
        } else if (handler.getWorld().getWorldName() == "worldTwo" && handler.getGame().isWorldOneIsActivated()) {
            if (handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0, 0).intersects(worldTwoExitBounds))
            //   if (handler.getWorld().getEntityManager().getPlayer().getX() <= 20 && handler.getWorld().getEntityManager().getPlayer().getY() <= 95)
            {
                handler.setWorld(handler.getGame().getWorldManager().getWorldFromList(0));

                State.setState(handler.getGame().loadingState);



            }

        }


        handler.getGameCamera().move(1, 1);
    }

    @Override
    public void render(Graphics g) {

        handler.getWorld().render(g);
        //debug EXIT WORLD BOUNDRY ZONE
      //  g.setColor(Color.RED);
     //   g.fillRect(worldOneExitBounds.x, worldOneExitBounds.y, worldOneExitBounds.width, worldOneExitBounds.height);
     //   g.fillRect(worldTwoExitBounds.x, worldTwoExitBounds.y, worldTwoExitBounds.width, worldTwoExitBounds.height);
        //g.fillRect(worldOneExitBounds.x, worldOneExitBounds.y, worldOneExitBounds.width, worldOneExitBounds.height);
        //  g.fillRect(worldTwoExitBounds.x, worldTwoExitBounds.y, worldTwoExitBounds.width, worldTwoExitBounds.height);


    }

}
