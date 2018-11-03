package Items;

import com.wc.bestgame.Handler;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by wc_an on 20-May-17.
 */
public class ItemManager {

    private Handler handler;
    private ArrayList<Item> items;


    public ItemManager(Handler handler) {
        this.handler = handler;
        items=new ArrayList<>();

    }

    public void tick() {
        Iterator<Item> itemIterator=items.iterator();
        while(itemIterator.hasNext()){
            Item i=itemIterator.next();
            i.tick();
            if(i.isPickedUp()){
                itemIterator.remove();
            }
        }
    }

    public void render(Graphics g) {
        for(Item i: items){
            i.render(g);
        }

    }

    public void addItem(Item i){
        i.setHandler(handler);
        items.add(i);

    }

    public Handler getHandler() {
        return handler;
    }
}
