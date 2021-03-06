package input;

import java.awt.event.KeyEvent;
import java.util.HashMap;

import static util.Units.booltf;

public class EventManager
{
    HashMap<Integer, Float> actions;

    public EventManager()
    {
        actions = new HashMap<>();
    }

    public float getActionStrength(int event)
    {
        return actions.getOrDefault(event, null);
    }

    public void update(KeyEvent event)
    {
        var code = event.getKeyCode();
        if (actions.containsKey(code))
        {
            actions.replace(event.getKeyCode(), booltf(event.getID() == KeyEvent.KEY_PRESSED));
        }
    }

    public void track(int event)
    {
        actions.putIfAbsent(event, 0f);
    }

    public void flush()
    {
        for (var key : actions.keySet())
        {
            actions.replace(key, 0f);
        }
    }
}
