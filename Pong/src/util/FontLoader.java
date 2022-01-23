package util;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FontLoader
{
    private static Font blippo;

    public static Font loadBlippo()
    {
        try
        {
            blippo = Font.createFont(Font.TRUETYPE_FONT,
                    new File("Pong/assets/Blippo.ttf"));

            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT,
                    new File("Pong/assets/Blippo.ttf")));

            blippo = blippo.deriveFont(Font.PLAIN, 24);
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
