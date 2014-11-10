package input.engine.mouse;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class Mouse {
	
	public int mouseX = 0;
	public int mouseY = 0;
	public int pressedX = 0;
	public int pressedY = 0;
	public int releasedX = 0;
	public int releasedY = 0;
	public int draggedX = 0;
	public int draggedY = 0;
	private int mouseWheel = 0;
	private boolean mouseWheelMoved = false;
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
	
	/**
	 * Returns the mouseWheel index, can return any integer.
	 * @return mouseWheel
	 */
	public int getMouseWheel() {
		return mouseWheel;
	}
	
	/**
	 * Returns the mouseWheel index, can return any integer greater than minValue
	 * @param minValue the min value for which the mouseWheel index can be returned.
	 * @return mouseWheel or minValue
	 */
	public int getMouseWheelMIN(int minValue) {
		if(mouseWheel < minValue) {
			return minValue;
		} else {
			return mouseWheel;
		}
	}
	
	/**
	 * Returns the mouseWheel index, can return any integer less than maxValue
	 * @param maxValue the max value for which the mouseWheel index can be returned.
	 * @return mouseWheel or maxValue
	 */
	public int getMouseWheelMAX(int maxValue) {
		if(mouseWheel > maxValue) {
			return maxValue;
		} else {
			return mouseWheel;
		}
	}
	
	/**
	 * Returns the mouseWheel index, can return any integer greater than minValue and less than the maxValue
	 * @param minValue the min value for which the mouseWheel index can be returned.
	 * @param maxValue the max value for which the mouseWheel index can be returned.
	 * @param defaultValue the value it will return if mouseWheel is less than minValue or mouseWheel is greater than maxValue
	 * @return mouseWheel or defaultValue
	 */
	public int getMouseWheel(int minValue, int maxValue, int defaultValue) {
		if(mouseWheel > minValue && mouseWheel < maxValue) {
			return mouseWheel;
		} else {
			return defaultValue;
		}
	}
	
	public void resetMouseWheel() {
		mouseWheel = 0;
	}
	
	public void setMouseWheelMoved(boolean value) {
		mouseWheelMoved = value;
	}
	
	public boolean getMouseWheelMoved() {
		return mouseWheelMoved;
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
	    
	    @Override
	    public void mouseWheelMoved(MouseWheelEvent e) {
	    	mouseWheel += e.getWheelRotation();
	    	mouseWheelMoved = true;
	    }
	    
	    @Override
	    public void mouseDragged(MouseEvent e) {
	    	int mx = e.getX();
	    	int my = e.getY();
	    	draggedX = mx;
	    	draggedY = my;
	    	pressed = true;
	    }
	}
	
	
}
