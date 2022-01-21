package util.fonts;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class LoadFonts {
    private static Font blippo;

    public static void setBlippo()
    {
        try
        {
            blippo = Font.createFont(Font.TRUETYPE_FONT,
                    new File("assets/Blippo.ttf"));

            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT,
                    new File("assets/Blippo.ttf")));

            blippo = blippo.deriveFont(Font.PLAIN, 24);
        } catch (IOException | FontFormatException e)
        {
            e.printStackTrace();
        }

    }

    public static Font getBlippo()
    {
        return blippo;
    }
}
