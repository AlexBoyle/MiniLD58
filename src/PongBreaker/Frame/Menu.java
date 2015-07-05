package PongBreaker.Frame;

import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JPanel;

import PongBreaker.Input.MenuInput;



@SuppressWarnings("serial")
public class Menu  extends JPanel
{
	private int changeState = -1;
	SpriteSheet menu = new SpriteSheet( 800, 400, "Menu.png");
	SpriteSheet  button = new SpriteSheet(200, 75, "buttons.png");
	SpriteSheet  Major = new SpriteSheet(25,25, "Major.png");
	public Menu()
	{
		
	}
	
	public void paint(Graphics g) 
	{
		super.paint(g);
		g.drawImage(menu.getImage(0, 0), 0, 0,null);
		
		if(MenuInput.buttonOn() == 0 &&  MenuInput.Mouse()){
			g.drawImage(button.getImage(0, 1), 300, 175, null);
			changeState = 1;
		}
		else if (MenuInput.buttonOn() == 0)
		{
			g.drawImage(button.getImage(0, 2), 300, 175, null);
		}
		else{
			g.drawImage(button.getImage(0, 0), 300, 175, null);
		}
		if (MenuInput.buttonOn() == 1 &&  MenuInput.Mouse())
		{
			g.drawImage(button.getImage(1, 1), 300, 275, null);
			changeState = 2;
		}
		else if (MenuInput.buttonOn() == 1){
			g.drawImage(button.getImage(1, 2), 300, 275, null);
		}
		else{
			g.drawImage(button.getImage(1, 0), 300, 275, null);
		}
		
		g.drawImage(Major.getImage(0, 0), 770, 370,null);
		
		
		
		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	
	}
	
	public void update()
	{
	
	repaint();
	}
	public int changeState(){
		return changeState;
	}
	
	
}
