package gfx.gfx;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by wc_an on 22-May-17.
 */
public class FontLoader {

    public static Font FontLoader(String path, float size) {

        try {
            return Font.createFont(Font.TRUETYPE_FONT, new File(path)).deriveFont(Font.PLAIN, size);
        } catch (FontFormatException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }

}
