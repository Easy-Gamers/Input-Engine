package input.engine.mouse;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mouse {
	
	public int mouseX = 0;
	public int mouseY = 0;
	public int pressedX = 0;
	public int pressedY = 0;
	public int releasedX = 0;
	public int releasedY = 0;
	public boolean pressed = false;
	
	public int[] getPressed() {
		int[] press = {
			pressedX, pressedY	
		};
		if(!pressed) {
		pressedX = 0;
		pressedY = 0;
		}
		return press;
	}
	
	public class MouseHandler extends MouseAdapter {
	    @Override
	    public void mouseMoved(MouseEvent e) {
	        int mx = (e.getX());
	        int my = (e.getY());
	        mouseX = mx;
	        mouseY = my;
	    }
	    
	    @Override
	    public void mousePressed(MouseEvent e) {
	        int mx = (e.getX()); // Mouse X position
	    	int my = (e.getY()); // Mouse Y position
	    	pressedX = mx;
	    	pressedY = my;
	    	pressed = true;
	    }
	    
	    @Override
	    public void mouseReleased(MouseEvent e) {
	    	int mx = e.getX();
	    	int my = e.getY();
	    	releasedX = mx;
	    	releasedY = my;
	    	pressed = false;
	    }
	}
	
	
}
