package input.engine.keyboard;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Key {
		
		public int presses, absorbs;
		public boolean down, pressed;
        public int kevent;
        
        public static List<Key> keys = new ArrayList<>();
        
        public String name;
        public String effect;
                    
        public Key(int ke) {
        	name = KeyEvent.getKeyText(ke);
            setKeyEvent(ke);
        }
                    
        public void setKeyEvent(int ke) {
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
			return (effect == null) ? name : effect;
		}
		
		public void setEffect(String effect) {
			this.effect = effect;
		}
		
//		private static void setEffect(int kevent, String effect) {
//			if(keys.size() > kevent) {
//				Key key = keys.get(kevent);
//				key.effect = effect;
//			}
//		}
		
		public static void setKeys() {
			Key key;
			for(int i = 0; i < KeyEvent.KEY_LAST; i++) {
				key = new Key(i);
				keys.add(key);
//				setEffect(KeyEvent.VK_W, "Up"); // W
//				setEffect(KeyEvent.VK_UP, "Up"); // Arrow
//				setEffect(KeyEvent.VK_A, "Left"); // A
//				setEffect(KeyEvent.VK_LEFT, "Left"); // Arrow
//				setEffect(KeyEvent.VK_D, "Right"); // D
//				setEffect(KeyEvent.VK_RIGHT, "Right"); // Arrow
//				setEffect(KeyEvent.VK_S, "Down"); // S
//				setEffect(KeyEvent.VK_DOWN, "Down"); // Arrow
//				setEffect(KeyEvent.VK_ENTER, "Enter"); // Enter
//				setEffect(KeyEvent.VK_1, "1"); // One
//				setEffect(KeyEvent.VK_2, "2"); // Two
//				setEffect(KeyEvent.VK_3, "3"); // Three
//				setEffect(KeyEvent.VK_4, "4"); // Four
//				setEffect(KeyEvent.VK_5, "5"); // Five
//				setEffect(KeyEvent.VK_6, "6"); // Six
//				setEffect(KeyEvent.VK_7, "7"); // Seven
//				setEffect(KeyEvent.VK_8, "8"); // Eight
//				setEffect(KeyEvent.VK_9, "9"); // Nine
//				setEffect(KeyEvent.VK_0, "0"); // Zero
//				setEffect(KeyEvent.VK_ESCAPE, "Escape"); // Esc
//				setEffect(KeyEvent.VK_I, "Inventory"); // I
//				setEffect(KeyEvent.VK_E, "Equipment"); // E
//				setEffect(KeyEvent.VK_M, "Minimap"); // M
//				setEffect(KeyEvent.VK_SHIFT, "Shift"); // Shift
			}
			key = null;
		}
		
		public static Key getKey(String name) {
			for(Key key : keys) {
				if(key.name.equals(name)) {
					return key;
				}
			}
			return null;
		}
		
		public static Key getKey(int kEvent) {
			for(Key key : keys) {
				if(key.kevent == kEvent) {
					return key;
				}
			}
			return null;
		}
}
