package PongBreaker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



import javax.swing.JFrame;

import PongBreaker.Frame.Game;
import PongBreaker.Frame.Menu;
import PongBreaker.Input.GameInput;
import PongBreaker.Input.MenuInput;






/*
 * This is used as a bare bone setup for a java game that uses a tick system to update graphics.
 */
@SuppressWarnings("serial")
public class PongBreaker extends JFrame  
{
	// objects
	Game game = new Game();
	Menu menu = new Menu();
	GameInput gInput = new GameInput();
	MenuInput mInput = new MenuInput();
	//State boolean
	boolean bMenu = true;
	boolean bGame = false;
	boolean starting = true;
	boolean end = false;
	
	//Vars
	 int posX=0,posY=0;
	 private long oldMs = 0;
	 private final int TICK = 10;
	 public final static int GAME_WIDTH = 800, GAME_HEIGHT = 400;
	 private int wait = 10;
	
	public PongBreaker() 
	{
		
		
		//JFrame setup
		
		setUndecorated(true);
		setTitle(" ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(GAME_WIDTH, GAME_HEIGHT);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		setVisible(true);
		setBackground(Color.BLUE);
		
		this.addMouseListener(new MouseAdapter()
		{
		   public void mousePressed(MouseEvent e)
		   {
		      posX=e.getX();
		      posY=e.getY();
		   }
		});
		this.addMouseMotionListener(new MouseAdapter()
		{
		     public void mouseDragged(MouseEvent evt)
		     {
				
		    	 if (MenuInput.buttonOn() == 0 &&  MenuInput.Mouse() || MenuInput.buttonOn() == 1){
		    		 
		    	 }else {
				setLocation (evt.getXOnScreen()-posX,evt.getYOnScreen()-posY);
		    	 }	
		     }
		});
		
		
		
		
		stuff();
	}
	
	
	
	
	
	
	
	public void stuff() 
	{
		oldMs=System.currentTimeMillis();
		while(true)
		{
			if (oldMs+TICK < System.currentTimeMillis() )
			{
				oldMs = System.currentTimeMillis();	
				//code
				 if (bMenu)
					{
						if (wait < 0)
						{
							if (starting)
							{
								//removing stuff
								remove();
								getContentPane().removeAll();
								//adding
								menu = new Menu();
								addKeyListener(mInput);
								addMouseListener(mInput);
								addMouseWheelListener(mInput);
								addMouseMotionListener(mInput);
								getContentPane().add(menu);
								validate();
								
								//stop 
								starting = false;
								
							}
							menu.update();
							
							changeState(menu.changeState());
						}else {
							wait --;
							menu.update();
							
						}
					}
				 else if (bGame)
					{
						if (wait < 0)
						{
							if (starting)
							{
								//removing stuff
								remove();
								getContentPane().removeAll();
								//adding
								game = new Game();
								addKeyListener(gInput);
								addMouseListener(gInput);
								addMouseWheelListener(gInput);
								getContentPane().add(game);
								validate();
								
								//stop 
								starting = false;
								
							}
							game.update();
							if(game.menu(false)){
								changeState(0);
							}
							if( game.restart(false)){
								changeState(1);
							}
							
							
						}else {
							wait --;
							menu.update();
							
						}
					}
				 else if(end){
					 
					 if (wait > 0){
						 wait --;
					 }
					 else {
						 System.exit(0);
					 }
				 }
			}
		} 
	}
	/*
	 * @param state changes the "state" of the game
	 * 
	 */
	public void changeState(int state)
	{
		if (state == 0)
		{
			wait = 10;
			bMenu = true;
			bGame = false;
			end = false;
			starting = true;
			
		}
		else if (state == 1)
		{
			wait = 10;
			bMenu = false;
			bGame = true;
			end = false;
			starting = true;
		}
		else if (state == 2)
		{
			wait = 10;
			bMenu = false;
			bGame = false;
			end = true;
			starting = true;
		}
		
	}
		
	
	
	/*
	 * This will remove all objects from the JFrame 
	 */
	private void remove()
	{
		getContentPane().removeAll();
		
		removeMouseMotionListener(mInput);
		removeKeyListener(gInput);
		removeMouseListener(gInput);
		removeMouseWheelListener(gInput);
		removeKeyListener(mInput);
		removeMouseListener(mInput);
		removeMouseWheelListener(mInput);
	}


	
	
	
	






	public static void main(String[] args) 
	{	
		//You Ready
		new PongBreaker();
	}
}
	
	


