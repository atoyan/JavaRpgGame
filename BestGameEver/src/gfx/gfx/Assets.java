package gfx.gfx;

import com.sun.javafx.tk.*;

import java.awt.*;
import java.awt.font.*;
import java.awt.image.BufferedImage;

/**
 * Created by wc_an on 5/5/2017.
 */
public class Assets {
    private static final int width = 48, height = 48;
    public static BufferedImage hero,inventory, dirt, stone, grass,wood, testHero,tree,disposableTree,start1,start2;
    public static BufferedImage[] player_down;
    public static BufferedImage[] player_left;
    public static BufferedImage[] player_right;
    public static BufferedImage[] player_up;
    public static BufferedImage[] start;
    public static BufferedImage[] attackLeft;
    public static BufferedImage[] attackRight;
    public static BufferedImage[] attackUp;
    public static BufferedImage[] attackDown;
    public static BufferedImage[] loadingScreen;

    private static ImageLoader imgldr;
    public static Font font;

    public static void init() {
        //FONT LOADER
        font= FontLoader.FontLoader("res/fonts/Vecna.otf",48);
        //
        imgldr = new ImageLoader();
        start=new BufferedImage[2];
        player_down = new BufferedImage[8];
        player_left = new BufferedImage[8];
        player_right = new BufferedImage[8];
        player_up = new BufferedImage[8];
        attackDown = new BufferedImage[3];
        attackLeft = new BufferedImage[3];
        attackRight = new BufferedImage[3];
        attackUp = new BufferedImage[3];
        loadingScreen=new BufferedImage[4];


        player_left[0] = imgldr.loadImage("/textures/hero.png").getSubimage(0, height , width, height);
        player_left[1] = imgldr.loadImage("/textures/hero.png").getSubimage(width, height , width, height);
        player_left[2] = imgldr.loadImage("/textures/hero.png").getSubimage(width * 2, height, width, height);

        player_right[0] = imgldr.loadImage("/textures/hero.png").getSubimage(0, height * 2, width, height);
        player_right[1] = imgldr.loadImage("/textures/hero.png").getSubimage(width, height * 2, width, height);
        player_right[2] = imgldr.loadImage("/textures/hero.png").getSubimage(width * 2, height * 2, width, height);


        player_up[0] = imgldr.loadImage("/textures/heroSheet.png").getSubimage(72,522,45,50);
        player_up[1] = imgldr.loadImage("/textures/heroSheet.png").getSubimage(142,522,45,50);
        player_up[2] = imgldr.loadImage("/textures/heroSheet.png").getSubimage(204,522,45,50);
        player_up[3] = imgldr.loadImage("/textures/heroSheet.png").getSubimage(268,522,45,50);
        player_up[4] = imgldr.loadImage("/textures/heroSheet.png").getSubimage(332,522,45,50);
        player_up[5] = imgldr.loadImage("/textures/heroSheet.png").getSubimage(397,522,45,50);
        player_up[6] = imgldr.loadImage("/textures/heroSheet.png").getSubimage(462,522,45,50);
        player_up[7] = imgldr.loadImage("/textures/heroSheet.png").getSubimage(525,522,45,50);

        player_down[0] = imgldr.loadImage("/textures/heroSheet.png").getSubimage(72,650,45,50);
        player_down[1] = imgldr.loadImage("/textures/heroSheet.png").getSubimage(142,650,45,50);
        player_down[2] = imgldr.loadImage("/textures/heroSheet.png").getSubimage(204,650,45,50);
        player_down[3] = imgldr.loadImage("/textures/heroSheet.png").getSubimage(268,650,45,50);
        player_down[4] = imgldr.loadImage("/textures/heroSheet.png").getSubimage(332,650,45,50);
        player_down[5] = imgldr.loadImage("/textures/heroSheet.png").getSubimage(397,650,45,50);
        player_down[6] = imgldr.loadImage("/textures/heroSheet.png").getSubimage(462,650,45,50);
        player_down[7] = imgldr.loadImage("/textures/heroSheet.png").getSubimage(525,650,45,50);


        player_left[0] = imgldr.loadImage("/textures/heroSheet.png").getSubimage(72,589,45,50);
        player_left[1] = imgldr.loadImage("/textures/heroSheet.png").getSubimage(142,589,45,50);
        player_left[2] = imgldr.loadImage("/textures/heroSheet.png").getSubimage(204,589,45,50);
        player_left[3] = imgldr.loadImage("/textures/heroSheet.png").getSubimage(268,589,45,50);
        player_left[4] = imgldr.loadImage("/textures/heroSheet.png").getSubimage(332,589,45,50);
        player_left[5] = imgldr.loadImage("/textures/heroSheet.png").getSubimage(397,589,45,50);
        player_left[6] = imgldr.loadImage("/textures/heroSheet.png").getSubimage(462,589,45,50);
        player_left[7] = imgldr.loadImage("/textures/heroSheet.png").getSubimage(525,589,45,50);

        player_right[0] = imgldr.loadImage("/textures/heroSheet.png").getSubimage(72,713,45,50);
        player_right[1] = imgldr.loadImage("/textures/heroSheet.png").getSubimage(142,713,45,50);
        player_right[2] = imgldr.loadImage("/textures/heroSheet.png").getSubimage(204,713,45,50);
        player_right[3] = imgldr.loadImage("/textures/heroSheet.png").getSubimage(268,713,45,50);
        player_right[4] = imgldr.loadImage("/textures/heroSheet.png").getSubimage(332,713,45,50);
        player_right[5] = imgldr.loadImage("/textures/heroSheet.png").getSubimage(397,713,45,50);
        player_right[6] = imgldr.loadImage("/textures/heroSheet.png").getSubimage(462,713,45,50);
        player_right[7] = imgldr.loadImage("/textures/heroSheet.png").getSubimage(525,713,45,50);

      //  attackUp[0]= imgldr.loadImage("/textures/heroSheet.png").getSubimage(70,1420,45,50);
     //   attackUp[1]= imgldr.loadImage("/textures/heroSheet.png").getSubimage(255,1420,50,50);
      //  attackUp[2]= imgldr.loadImage("/textures/heroSheet.png").getSubimage(446,1420,50,50);
        attackUp[0]= imgldr.loadImage("/textures/heroSheet.png").getSubimage(626,1420,60,50);
        attackUp[1]= imgldr.loadImage("/textures/heroSheet.png").getSubimage(820,1402,85,70);
        attackUp[2]= imgldr.loadImage("/textures/heroSheet.png").getSubimage(1040,1400,82,66);

      //  attackLeft[0]= imgldr.loadImage("/textures/heroSheet.png").getSubimage(53,1611,53,52);
     //   attackLeft[1]= imgldr.loadImage("/textures/heroSheet.png").getSubimage(266,1611,34,52);
     //   attackLeft[2]= imgldr.loadImage("/textures/heroSheet.png").getSubimage(464,1611,40,50);
        attackLeft[0]= imgldr.loadImage("/textures/heroSheet.png").getSubimage(644,1611,61,50);
        attackLeft[1]= imgldr.loadImage("/textures/heroSheet.png").getSubimage(779,1611,100,52);
        attackLeft[2]= imgldr.loadImage("/textures/heroSheet.png").getSubimage(979,1611,92,52);

    //    attackRight[0]= imgldr.loadImage("/textures/heroSheet.png").getSubimage(83,1998,55,54);
    //    attackRight[1]= imgldr.loadImage("/textures/heroSheet.png").getSubimage(278,1998,41,54);
     //   attackRight[2]= imgldr.loadImage("/textures/heroSheet.png").getSubimage(456,1998,43,54);
        attackRight[0]= imgldr.loadImage("/textures/heroSheet.png").getSubimage(642,1998,57,54);
        attackRight[1]= imgldr.loadImage("/textures/heroSheet.png").getSubimage(851,1998,99,54);
        attackRight[2]= imgldr.loadImage("/textures/heroSheet.png").getSubimage(1040,1998,96,54);

    //    attackDown[0]= imgldr.loadImage("/textures/heroSheet.png").getSubimage(70,1803,40,50);
      //  attackDown[1]= imgldr.loadImage("/textures/heroSheet.png").getSubimage(256,1803,40,50);
        //attackDown[2]= imgldr.loadImage("/textures/heroSheet.png").getSubimage(447,1803,45,50);
        attackDown[0]= imgldr.loadImage("/textures/heroSheet.png").getSubimage(632,1803,50,50);
        attackDown[1]= imgldr.loadImage("/textures/heroSheet.png").getSubimage(820,1803,60,70);
        attackDown[2]= imgldr.loadImage("/textures/heroSheet.png").getSubimage(1040,1803,60,66);
        loadingScreen[0]=imgldr.loadImage("/loadingScreen0.png");
        loadingScreen[1]=imgldr.loadImage("/loadingScreen1.png");
        loadingScreen[2]=imgldr.loadImage("/loadingScreen2.png");
        loadingScreen[3]=imgldr.loadImage("/loadingScreen3.png");
        start[0]=imgldr.loadImage("/startfirst.png");
        start[1]=imgldr.loadImage("/startsecond.png");
        hero = imgldr.loadImage("/textures/heroSheet.png").getSubimage(12,650,45,50);
        dirt = imgldr.loadImage("/textures/dirt.png").getSubimage(0, 0, width, height);
        stone = imgldr.loadImage("/textures/stone.png").getSubimage(0, 0, width, height);
        grass = imgldr.loadImage("/textures/grass.png").getSubimage(0, 0, width, height);
        tree = imgldr.loadImage("/textures/trees.png").getSubimage(0, 0, 100, 110);
        disposableTree = imgldr.loadImage("/textures/trees.png").getSubimage(260, 0, 60 ,120);
        wood=imgldr.loadImage("/wood.png");
        inventory=imgldr.loadImage("/Inventory.png");
    }


}
