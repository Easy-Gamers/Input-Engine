package input.engine.mouse;

import java.awt.Canvas;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class Mouse {
	
	public static int LEFT = 0, MIDDLE = 1, RIGHT = 2;
	
	private int mouseX = 0;
	private int mouseY = 0;
	private int pressedX = 0;
	private int pressedY = 0;
	private int releasedX = 0;
	private int releasedY = 0;
	private int draggedX = 0;
	private int draggedY = 0;
	private int mouseWheel = 0;
	private boolean mouseWheelMoved = false;
	private boolean pressed = false;
	private int button = LEFT;
	
	public static final int X = 0, Y = 1;
	
	public void reset() {
		resetPressedPos();
		resetReleasedPos();
		resetDraggedPos();
		resetMouseWheel();
	}
	
	public boolean isPressed() {
		return pressed;
	}
	
	public void setPressed(boolean pressed) {
		this.pressed = pressed;
	}
	
	/**
	 * Returns what mouse button was pressed
	 * @return LEFT, MIDDLE, or RIGHT
	 */
	public int mouseClicked() {
		return button;
	}
	
	public int getPressed(int var) {
		return (var == X) ? pressedX : pressedY;
	}
	
	public int getReleased(int var) {
		return (var == X) ? releasedX : releasedY;
	}
	
	public int getDragged(int var) {
		return (var == X) ? draggedX : draggedY;
	}
	
	public void resetPressedPos() {
		pressedX = 0;
		pressedY = 0;
	}
	
	public void resetReleasedPos() {
		releasedX = 0;
		releasedY = 0;
	}
	
	public void resetDraggedPos() {
		draggedX = 0;
		draggedY = 0;
	}
	
	public int getMousePos(int var) {
		return (var == X) ? mouseX : mouseY;
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
	
	public Mouse(Canvas game) {
		game.addMouseListener(new MouseHandler());
		game.addMouseMotionListener(new MouseHandler());
		game.addMouseWheelListener(new MouseHandler());
	}
	
	public class MouseHandler extends MouseAdapter {
		
	    @Override
	    public void mouseMoved(MouseEvent e) {
	        mouseX = (e.getX());
	        mouseY = (e.getY());
	    }
	    
	    @Override
	    public void mousePressed(MouseEvent e) {
	        pressedX = (e.getX()); // Mouse X position
	    	pressedY = (e.getY()); // Mouse Y position
	    	pressed = true;
	    }
	    
	    @Override
	    public void mouseReleased(MouseEvent e) {
	    	releasedX = e.getX();
	    	releasedY = e.getY();
	    	pressed = false;
	    }
	    
	    @Override
	    public void mouseWheelMoved(MouseWheelEvent e) {
	    	mouseWheel = e.getWheelRotation();
	    	mouseWheelMoved = true;
	    }
	    
	    @Override
	    public void mouseDragged(MouseEvent e) {
	    	draggedX = e.getX();
	    	draggedY = e.getY();
	    	pressed = true;
	    }
	}
	
	
}
