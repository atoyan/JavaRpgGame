package entity;

import Inventory.Inventory;
import com.wc.bestgame.Handler;
import gfx.gfx.Animation;
import gfx.gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Player extends Creature {
    protected int health;
    boolean atUp, atDown, atLeft, atRight;
    private Animation animDown;
    private Animation animUp;
    private Animation animLeft;
    private Animation animRight;
    private Animation attackLeft, attackRight, attackUp, attackDown;
    private long lastAttackTimer;
    private long attackCooldown = 200, attackTimer = attackCooldown;
    private Inventory inventory;

    private BufferedImage[] allFrames;

    public Player(Handler handler, float x, float y) {

        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

        bounds.x = 10;
        bounds.y = 10;
        bounds.width = 40;
        bounds.height = 40;
        health = 3;

        animUp = new Animation(200, Assets.player_up);
        animDown = new Animation(200, Assets.player_down);
        animLeft = new Animation(200, Assets.player_left);
        animRight = new Animation(200, Assets.player_right);
        attackUp = new Animation(200, Assets.attackUp);
        attackLeft = new Animation(200, Assets.attackLeft);
        attackRight = new Animation(200, Assets.attackRight);
        attackDown = new Animation(200, Assets.attackDown);
        allFrames = new Animation(200, Assets.attackUp).getFrames();


        inventory = new Inventory(handler);


    }

    @Override
    public void render(Graphics g) {

        g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);


    }

    public void postRender(Graphics g){
        inventory.render(g);
    }

    private int getCurrentIndex() {
        if (atUp == true) {
            return attackUp.index();
        }
        return 0;
    }

    private BufferedImage getCurrentAnimationFrame() {
        while (xMove < 0) {
            return animLeft.getCurrentFrame();
        }
        while (xMove > 0) {
            return animRight.getCurrentFrame();

        }
        while (yMove < 0) {
            return animUp.getCurrentFrame();
        }
        while (yMove > 0) {
            return animDown.getCurrentFrame();
        }
        if (handler.getKeyManager().aUp) {

            return attackUp.getCurrentFrame();
        } else if (handler.getKeyManager().aDown) {
            return attackDown.getCurrentFrame();
        } else if (handler.getKeyManager().aLeft) {
            return attackLeft.getCurrentFrame();
        } else if (handler.getKeyManager().aRight) {
            return attackRight.getCurrentFrame();
        }

        return Assets.hero;
    }


    @Override
    public void die() {
        System.out.print("You Loose");
    }


    @Override
    public void tick() {
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
        //AnimationUpdate
        animDown.tick();
        animUp.tick();
        animLeft.tick();
        animRight.tick();
        attackUp.tick();
        attackDown.tick();
        attackLeft.tick();
        attackRight.tick();
        checkAttacks();
        inventory.tick();


    }

    private void checkAttacks() {
        attackTimer += System.currentTimeMillis() - lastAttackTimer;
        lastAttackTimer = System.currentTimeMillis();
        if (attackTimer < attackCooldown) {
            return;
        }

        if(inventory.isActive())
            return;

        Rectangle cb = getCollisionBounds(0, 0);
        Rectangle ar = new Rectangle();
        int arSize = 20;
        ar.width = arSize;
        ar.height = arSize;

        if (handler.getKeyManager().aUp) {
            ar.x = cb.x + cb.width / 2 - arSize / 2;
            ar.y = cb.y - arSize;
        } else if (handler.getKeyManager().aDown) {
            ar.x = cb.x + cb.width / 2 - arSize / 2;
            ar.y = cb.y + cb.height;
        } else if (handler.getKeyManager().aLeft) {
            ar.x = cb.x - arSize;
            ar.y = cb.y + cb.height / 2 - arSize / 2;
        } else if (handler.getKeyManager().aRight) {
            ar.x = cb.x + cb.width;
            ar.y = cb.y + cb.height / 2 - arSize / 2;
        } else {
            return;
        }
        attackTimer = 0;

        for (Entity e : handler.getWorld().getEntityManager().getEntities()) {

            if (e.equals(this)) {
                continue;
            }
            if (e.getCollisionBounds(0, 0).intersects(ar)) {
                e.hurt(1);
                return;
            }

        }

    }

    private void getInput() {

        xMove = 0;
        yMove = 0;

        if(inventory.isActive())
            return;

        if (handler.getKeyManager().up) {

            yMove = -speed;
        }
        if (handler.getKeyManager().down) {
            yMove = speed;
        }
        if (handler.getKeyManager().left) {
            xMove = -speed;
        }
        if (handler.getKeyManager().right) {
            xMove = speed;
        }

    }


    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
