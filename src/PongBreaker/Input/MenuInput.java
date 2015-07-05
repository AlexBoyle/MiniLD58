package PongBreaker.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;







public class MenuInput implements KeyListener, MouseListener, MouseWheelListener, MouseMotionListener {
	private static int button = -1;
	private static boolean mouse;

	
	public static int buttonOn(){
		return button;
	}
	public static boolean Mouse(){
		return mouse;
	}
	
	public void mouseMoved(MouseEvent e){
		
	
	
		if (e.getX() > 300 && e.getX() < 500 && e.getY() > 175 && e.getY() < 250 && !mouse){
			button = 0;
		}
		else if(e.getX() > 300 && e.getX() < 500 && e.getY() > 275 && e.getY() < 350 && !mouse){
			button = 1;
		}
		else {
			button = -1;
		}
	}
	
	@Override
	public void keyPressed(KeyEvent k) {
		int key = k.getKeyCode();
		
		if (key == 87){
			
		}
		else if (key == 83){
			
		}
		else if (key == 65){
			
		}
		else if (key == 68){
			
		}
		
	}

	@Override
	public void keyReleased(KeyEvent k) {
		int key = k.getKeyCode();
		if (key == 87){
			
		}
		else if (key == 83){
			
		}
		else if (key == 65){
			
		}
		else if (key == 68){
			
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
		
	}

	@Override
	public void mouseClicked(MouseEvent m) {
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mousePressed(MouseEvent m) {
		mouse = true;
		
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		mouse = false;
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent m) {
		
		
	}
	public void mouseDragged(MouseEvent e){
		
	}

}
