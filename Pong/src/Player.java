import model.Entity;
import util.math.AABB;
import util.math.Vector2;

public class Player {
    AABB playerRect = new AABB(50, 50, 32, 32);
    Entity player = new Entity(playerRect)
    {
        @Override
        public void update()
        {
            var keys = keyInput.getKeyEvents();

            velocity = Vector2.ZERO;
            for (var event : keys)
            {
                var code = event.getKeyCode();
                if (code == KeyEvent.VK_W)
                {
                    velocity.y -= 2.5f;
                }
                if (code == KeyEvent.VK_A)
                {
                    velocity.x -= 2.5f;
                }
                if (code == KeyEvent.VK_S)
                {
                    velocity.y += 2.5f;
                }
                if (code == KeyEvent.VK_D)
                {
                    velocity.x += 2.5f;
                }
            }


            super.update();
        }
    };
        entities.add(player);
}
