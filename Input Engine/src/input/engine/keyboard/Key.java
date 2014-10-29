package input.engine.keyboard;

import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Key /*implements KeyListener*/ {
		
		public int presses, absorbs;
		public boolean down, pressed;
        public int kevent;
        
        public List<Integer> keyEvents = new ArrayList<>();
        public static Map<Integer, Key> keys = new HashMap<>();
        //public static List<String> names = new ArrayList<>();
        
        public String name;
        public String effect;
        
        public InputHandler input;

//		public Key(String name) {
//			this.name = name;
//			keys.put(name, this);
//		}
                    
        public Key(int ke, InputHandler input) {
        	name = KeyEvent.getKeyText(ke);
        	//keys.put(name, this);
        	keys.put(ke, this);
        	//names.add(name);
            setKeyEvent(ke);
            this.input = input;
        }
                    
        public void setKeyEvent(int ke) {
        	keyEvents.add(ke);
            kevent = ke;
        }

		public void toggle(boolean pressed) {
			if(pressed != down)  {
				down = pressed;
			}
			if(pressed) {
				presses++;
			}
		}

		public void tick() {
			if(absorbs < presses) {
				absorbs++;
				pressed = true;
			} else {
				pressed = false;
			}
		}
		
		public String getEffect() {
			/*
			if (a > b) {
  				max = a;
			} else {
  				max = b;
			}
			
			or
			
			max = (a > b) ? a : b;
			 */
			return (effect == null) ? name : effect;
		}
		
		public void setEffect(String effect) {
			this.effect = effect;
		}
		
		private static void setEffect(int kevent, String effect) {
			if(keys.size() > kevent) {
				Key key = keys.get(kevent);
				//System.out.println(key.name);
				//System.out.println(key.kevent);
				key.effect = effect;
//			for(Key key : keys.values()) {
//				if(key.kevent == kevent) {
//					key.effect = effect;
//				}
//			}
			}
		}
		
		public static void setKeys(InputHandler input) {
			@SuppressWarnings("unused")
			Key key;
			for(int i = 0; i < KeyEvent.KEY_LAST; i++) {
				key = new Key(i, input);
				setEffect(KeyEvent.VK_W, "Up"); // W
				setEffect(KeyEvent.VK_UP, "Up"); // Arrow
				setEffect(KeyEvent.VK_A, "Left"); // A
				setEffect(KeyEvent.VK_LEFT, "Left"); // Arrow
				setEffect(KeyEvent.VK_D, "Right"); // D
				setEffect(KeyEvent.VK_RIGHT, "Right"); // Arrow
				setEffect(KeyEvent.VK_S, "Down"); // S
				setEffect(KeyEvent.VK_DOWN, "Down"); // Arrow
				setEffect(KeyEvent.VK_ENTER, "Enter"); // Enter
				setEffect(KeyEvent.VK_1, "Enemy1"); // One
				setEffect(KeyEvent.VK_2, "Enemy2"); // Two
				setEffect(KeyEvent.VK_3, "Enemy3"); // Three
				setEffect(KeyEvent.VK_4, "Enemy4"); // Four
				setEffect(KeyEvent.VK_5, "Enemy5"); // Five
				setEffect(KeyEvent.VK_ESCAPE, "Escape"); // Esc
				setEffect(KeyEvent.VK_I, "Inventory"); // I
				setEffect(KeyEvent.VK_E, "Equipment"); // E
				setEffect(KeyEvent.VK_M, "Minimap"); // M
			}
			key = null;
		}

//		@Override
//		public void keyPressed(KeyEvent arg0) {
//			// TODO Auto-generated method stub
//			
//		}
//
//		@Override
//		public void keyReleased(KeyEvent arg0) {
//			// TODO Auto-generated method stub
//			
//		}
//
//		@Override
//		public void keyTyped(KeyEvent arg0) {
//			// TODO Auto-generated method stub
//			
//		}
}
