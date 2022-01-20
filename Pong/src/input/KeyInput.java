package input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

public class KeyInput extends KeyAdapter
{
    private final LinkedList<KeyEvent> keyEvents = new LinkedList<>();  // keep track of key input asynchronously

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

    public LinkedList<KeyEvent> getKeyEvents()
    {
        return keyEvents;
    }

    public void flush()
    {
        keyEvents.clear();
    }

}
