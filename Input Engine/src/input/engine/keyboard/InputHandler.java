package input.engine.keyboard;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Canvas;

public class InputHandler implements KeyListener {
		
		public void tick() {
			for(Key key : Key.keys) {
				key.tick();
			}
		}

		public InputHandler(Canvas game) {
			game.addKeyListener(this);
			Key.setKeys();
		}

		@Override
		public void keyPressed(KeyEvent e) {
			toggle(e, true);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			toggle(e, false);
		}

		@Override
		public void keyTyped(KeyEvent e) {
			
		}

		public void toggle(KeyEvent ke, boolean pressed) {
			int k = ke.getKeyCode();
            
			for(Key key : Key.keys) {
				if(k == key.kevent) key.toggle(pressed);
			}
		}
}