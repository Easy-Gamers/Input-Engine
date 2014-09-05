package input.engine.keyboard;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.Canvas;

public class InputHandler implements KeyListener {
		
		public void tick() {
			for(Key key : Key.keys.values()) {
				key.tick();
			}
		}

//		public Key up = new Key(KeyEvent.VK_UP);
//		public Key down = new Key(KeyEvent.VK_DOWN);
//		public Key left = new Key(KeyEvent.VK_LEFT);
//		public Key right = new Key(KeyEvent.VK_RIGHT);
//		public Key enter = new Key(KeyEvent.VK_ENTER);
////		public Key use_rod = new Key();
////		public Key cursor_up = new Key();
////		public Key cursor_down = new Key();
//		public Key space = new Key(KeyEvent.VK_SPACE);
//		public Key escape = new Key(KeyEvent.VK_ESCAPE);
////		public Key pageUp = new Key();
////		public Key pageDown = new Key();
////		public Key home = new Key();
//		public Key shift = new Key(KeyEvent.VK_SHIFT);
//		public Key one = new Key(KeyEvent.VK_1);
//		public Key two = new Key(KeyEvent.VK_2);
//		public Key three = new Key(KeyEvent.VK_3);
//		public Key four = new Key(KeyEvent.VK_4);
//		public Key five = new Key(KeyEvent.VK_5);
//		public Key six = new Key(KeyEvent.VK_6);
//		public Key seven = new Key(KeyEvent.VK_7);
//		public Key eight = new Key(KeyEvent.VK_8);
//		public Key nine = new Key(KeyEvent.VK_9);
//		public Key zero = new Key(KeyEvent.VK_0);
//		public Key deadgrave = new Key(KeyEvent.VK_DEAD_GRAVE);
//		public Key tilde = new Key(KeyEvent.VK_DEAD_TILDE);
//		public Key backspace = new Key(KeyEvent.VK_BACK_SPACE);
                
                //public Key attack = new Key();
		
//		public Key a = new Key(KeyEvent.VK_A);
//		public Key b = new Key(KeyEvent.VK_B);
//		public Key c = new Key(KeyEvent.VK_C);		
//		public Key d = new Key(KeyEvent.VK_D);
//		public Key e = new Key(KeyEvent.VK_E);
//		public Key f = new Key(KeyEvent.VK_F);
//		public Key g = new Key(KeyEvent.VK_G);
//		public Key h = new Key(KeyEvent.VK_H);
//		public Key i = new Key(KeyEvent.VK_I);
//		public Key j = new Key(KeyEvent.VK_J);
//		public Key k = new Key(KeyEvent.VK_K);
//		public Key l = new Key(KeyEvent.VK_L);		
//		public Key m = new Key(KeyEvent.VK_M);		
//		public Key n = new Key(KeyEvent.VK_N);
//		public Key o = new Key(KeyEvent.VK_O);
//		public Key p = new Key(KeyEvent.VK_P);
//		public Key q = new Key(KeyEvent.VK_Q);
//		public Key r = new Key(KeyEvent.VK_R);		
//		public Key s = new Key(KeyEvent.VK_S);		
//		public Key t = new Key(KeyEvent.VK_T);
//		public Key u = new Key(KeyEvent.VK_U);
//		public Key v = new Key(KeyEvent.VK_V);		
//		public Key w = new Key(KeyEvent.VK_W);	
//		public Key x = new Key(KeyEvent.VK_X);
//		public Key y = new Key(KeyEvent.VK_Y);
//		public Key z = new Key(KeyEvent.VK_Z);
		
//		public Key opensb = new Key();
//		public Key closesb = new Key();

		public InputHandler(Canvas game) {
			game.addKeyListener(this);
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
            
			for(Key key : Key.keys.values()) {
				if(k == key.kevent) key.toggle(pressed);
			}
			
//			if(k == up.kevent) up.toggle(pressed);
//			if(k == down.kevent) down.toggle(pressed);
//			if(k == left.kevent) left.toggle(pressed);
//			if(k == right.kevent) right.toggle(pressed);
//
//			if(k == KeyEvent.VK_W) w.toggle(pressed); // Up
//			if(k == KeyEvent.VK_S) s.toggle(pressed); // Down
//			//if(k == KeyEvent.VK_A) { a.toggle(pressed); attack.toggle(pressed); } // Left
//            if(k == KeyEvent.VK_A) a.toggle(pressed);
//			if(k == KeyEvent.VK_D) d.toggle(pressed); // Right
//			
//			if(k == KeyEvent.VK_W) up.toggle(pressed); // Up
//			if(k == KeyEvent.VK_S) down.toggle(pressed); // Down
//			if(k == KeyEvent.VK_A) left.toggle(pressed); // Left
//			if(k == KeyEvent.VK_D) right.toggle(pressed); // Right
//
//			if(k == KeyEvent.VK_2) cursor_up.toggle(pressed);
//			if(k == KeyEvent.VK_8) cursor_down.toggle(pressed);
//			if(k == KeyEvent.VK_SPACE) space.toggle(pressed);
//			if(k == KeyEvent.VK_ESCAPE) escape.toggle(pressed);
//			if(k == KeyEvent.VK_ENTER) enter.toggle(pressed);
//
//			if(k == KeyEvent.VK_L) use_rod.toggle(pressed);
//			
//			if(k == KeyEvent.VK_PAGE_UP) pageUp.toggle(pressed);
//			if(k == KeyEvent.VK_PAGE_DOWN) pageDown.toggle(pressed);
//			if(k == KeyEvent.VK_HOME) home.toggle(pressed);
//			
//			if(k == KeyEvent.VK_SHIFT) shift.toggle(pressed);
//			if(k == KeyEvent.VK_DEAD_GRAVE) deadgrave.toggle(pressed);
//			
//			if(k == KeyEvent.VK_1) one.toggle(pressed);
//			if(k == KeyEvent.VK_2) two.toggle(pressed);
//			if(k == KeyEvent.VK_3) three.toggle(pressed);
//			if(k == KeyEvent.VK_4) four.toggle(pressed);
//			if(k == KeyEvent.VK_5) five.toggle(pressed);
//			if(k == KeyEvent.VK_6) six.toggle(pressed);
//			if(k == KeyEvent.VK_7) seven.toggle(pressed);
//			if(k == KeyEvent.VK_8) eight.toggle(pressed);
//			if(k == KeyEvent.VK_9) nine.toggle(pressed);
//			if(k == KeyEvent.VK_0) zero.toggle(pressed);
//			
//			if(k == KeyEvent.VK_CLOSE_BRACKET) closesb.toggle(pressed);
//			if(k == KeyEvent.VK_OPEN_BRACKET) opensb.toggle(pressed);
//			
//			if(k == KeyEvent.VK_M) m.toggle(pressed);
//			if(k == KeyEvent.VK_I) i.toggle(pressed);
//                        if(k == KeyEvent.VK_E) e.toggle(pressed);
		}
}