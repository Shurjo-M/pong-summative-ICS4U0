import java.awt.event.KeyEvent;
import java.util.HashMap;

import static util.math.Units.booltf;

public class ActionMap
{
    HashMap<Integer, Float> actions;

    public ActionMap()
    {
        actions = new HashMap<>();
    }

    public void update(KeyEvent event)
    {
        actions.replace(event.getKeyCode(), booltf(event.getID() == KeyEvent.KEY_PRESSED));
    }

    public void track(KeyEvent event)
    {
        actions.putIfAbsent(event.getKeyCode(), booltf(event.getID() == KeyEvent.KEY_PRESSED));
    }
}
