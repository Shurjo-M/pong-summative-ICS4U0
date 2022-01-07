import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

public class Input
{
    private final LinkedList<KeyEvent> keyEvents = new LinkedList<>();

    // name is unused, but methods are important!
    private final KeyAdapter _keyAdapter = new KeyAdapter()
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

    public LinkedList<KeyEvent> getKeyEvents()
    {
        return keyEvents;
    }
}
