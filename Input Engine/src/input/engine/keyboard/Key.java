package input.engine.keyboard;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Key {
		
		public int presses, absorbs;
		public boolean down, pressed;
        public int kevent;
        
        public List<Integer> keyEvents = new ArrayList<>();
        public static Map<String, Key> keys = new HashMap<>();
        public static List<String> names = new ArrayList<>();
        
        public String name;
        public String effect;

//		public Key(String name) {
//			this.name = name;
//			keys.put(name, this);
//		}
                    
        public Key(int ke) {
        	name = KeyEvent.getKeyText(ke);
        	keys.put(name, this);
        	names.add(name);
            setKeyEvent(ke);
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
				Key key = keys.get(names.get(kevent));
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
		
		public static void setKeys() {
			Key key;
			for(int i = 0; i < KeyEvent.KEY_LAST; i++) {
				key = new Key(i);
				setEffect(87, "Up"); // W
				setEffect(38, "Up"); // Arrow
				setEffect(65, "Left"); // A
				setEffect(37, "Left"); // Arrow
				setEffect(68, "Right"); // D
				setEffect(39, "Right"); // Arrow
				setEffect(83, "Down"); // S
				setEffect(40, "Down"); // Arrow
				setEffect(27, "Escape"); // Esc
				//if(i == 87) key.setEffect(effect) = "Up";
				//if(i == 65) key.effect = "Left";
				//if(i == 68) key.effect = "Right";
			}
			key = null;
		}
}
