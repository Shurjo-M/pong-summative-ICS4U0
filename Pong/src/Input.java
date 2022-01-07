import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

public class Input
{
    private static final LinkedList<KeyEvent> keyEvents = new LinkedList<>();  // keep track of key input asynchronously
    private static final KeyAdapter _keyAdapter;  // name is unused, but methods are important!

    // necessary evil
    static
    {
        _keyAdapter = new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                super.keyPressed(e);
                keyEvents.add(e);
            }

            @Override
            public void keyReleased(KeyEvent e)
            {
                super.keyReleased(e);
                keyEvents.add(e);
            }
        };
    }

    public static LinkedList<KeyEvent> getKeyEvents()
    {
        return keyEvents;
    }
}
