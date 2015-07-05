package PongBreaker.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import PongBreaker.Entities.Player;
import PongBreaker.Frame.Game;







public class GameInput implements KeyListener, MouseListener, MouseWheelListener {
	
	
	@Override
	public void keyPressed(KeyEvent k) {
		int key = k.getKeyCode();
		System.out.println(key);
		if (key == 38){
			//up
			Player.changeY(-1);
		}
		else if (key == 40){
			//down
			Player.changeY(1);
		}
		
		else if (key == 27){
			Game.gotoMenu();
		}
		else if (key == 82){
			Game.gotorestart();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent k) {
		@SuppressWarnings("unused")
		int key = k.getKeyCode();
		Player.changeY(0);
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
		
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent m) {
		
		
	}

}
