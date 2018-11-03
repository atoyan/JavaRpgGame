package display;

import javafx.embed.swing.JFXPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by wc_an on 5/4/2017.
 */
public class Display {

    private JFrame frame;
    private Canvas canvas;
    private String title;
    private int height,width;

    public Display(String title,int width,int height){

            this.title=title;
            this.height=height;
            this.width=width;
            createDisplay();

    }

    private void createDisplay(){

        frame = new JFrame(title);
        frame.setSize(width,height);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setBackground(Color.BLACK);
        frame.setLocationRelativeTo(null);
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width,height));
        canvas.setMaximumSize(new Dimension(width,height));
        canvas.setMinimumSize(new Dimension(width,height));
        canvas.setFocusable(false);
        frame.add(canvas);
        frame.pack();


    }
    public Canvas getCanvas(){
        return canvas;

    }
    public JFrame getFrame(){
        return frame;
    }

}
