package util;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class LoadFonts {
    private static Font blippo;

    public static Font loadBlippo()
    {
        try
        {
            blippo = Font.createFont(Font.TRUETYPE_FONT,
                    new File("assets/Blippo.ttf"));

            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT,
                    new File("assets/Blippo.ttf")));

        } catch (IOException | FontFormatException e)
        {
            e.printStackTrace();
        }

        return blippo;
    }

    public static Font getBlippo()
    {
        return blippo;
    }
}
