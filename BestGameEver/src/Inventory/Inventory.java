package Inventory;

import Items.Item;
import com.wc.bestgame.Handler;
import gfx.gfx.Assets;
import gfx.gfx.Text;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Created by wc_an on 21-May-17.
 */
public class Inventory {

    private Handler handler;
    private boolean active = false;
    private ArrayList<Item> inventoryItems;
    private int invX = 50;
    private int invY = 50;
    private int invWidth = 800, invHeight = 600;
    private int invListCenterX = invX + 342, invListCenterY = invHeight / 2 + 5;
    private int invListSpacing = 50;

    private int invImageX = 552, invImageY = 122, invImageWidth = 128, invImageHeight = 128;

    private int invCountX = 584, invCountY = 236;

    private int selectedItem = 0;

    public Inventory(Handler handler) {
        this.handler = handler;
        inventoryItems = new ArrayList<>();


    }


    public void tick() {
        if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_E))
            active = !active;
        if (!active)
            return;

        if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_W))
            selectedItem--;
        if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_S))
            selectedItem++;

        if (selectedItem < 0)
            selectedItem = inventoryItems.size() - 1;

        else if (selectedItem >= inventoryItems.size())
            selectedItem = 0;

    }


    public void render(Graphics g) {
        if (!active)
            return;
        g.drawImage(Assets.inventory, invX, invY, invWidth, invHeight, null);
        int len = inventoryItems.size();
        if (len == 0)
            return;

        for (int i = -5; i <= 6; i++) {

            if (selectedItem + i < 0 || selectedItem + i >= len)
                continue;



            if (i == 0) {
                Text.drawString(g, inventoryItems.get(selectedItem + i).getItemName(), invListCenterX,
                        invListCenterY + i * invListSpacing, true, Color.YELLOW, Assets.font);
            } else {
                Text.drawString(g, inventoryItems.get(selectedItem + i).getItemName(), invListCenterX,
                        invListCenterY + i * invListSpacing, true, Color.white, Assets.font);
            }

        }
        Item item = inventoryItems.get(selectedItem);
        g.drawImage(item.getTexture(), invImageX, invImageY, invImageWidth, invImageHeight, null);
        Text.drawString(g, Integer.toString(item.getCount()), invCountX, invCountY, true, Color.white, Assets.font);
    }

    public void addItem(Item item) {
        for (Item i : inventoryItems) {
            if (i.getId() == item.getId()) {
                i.setCount(i.getCount() + item.getCount());
                return;
            }
        }
        inventoryItems.add(item);
    }

    public void removeItem(Item i) {
        inventoryItems.remove(i);
    }

    //////GETTERS AND SETTERS


    public boolean isActive() {
        return active;
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }


}
