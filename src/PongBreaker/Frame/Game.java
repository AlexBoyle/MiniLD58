package PongBreaker.Frame;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

import PongBreaker.Entities.AI;
import PongBreaker.Entities.Ball;
import PongBreaker.Entities.Blocks;
import PongBreaker.Entities.Player;
import PongBreaker.Entities.PowerUps;



@SuppressWarnings("serial")
public class Game  extends JPanel
{
	private PowerUps p = new PowerUps();
	private AI ai = new AI();
	private ArrayList<Ball> balls = new ArrayList<Ball>();
	private ArrayList<Blocks> blocks = new ArrayList<Blocks>();
	private ArrayList<Blocks> blockse = new ArrayList<Blocks>();
	private ArrayList<PowerUps> ups = new ArrayList<PowerUps>();
	
	int win = 0;
	 Player player = new Player();
	Random r = new Random();
	static boolean restart = false;
	static boolean menu = false;
	SpriteSheet AIW = new SpriteSheet( 800, 400, "AIWin.png");
	SpriteSheet PLW = new SpriteSheet( 800, 400, "PlayerWin.png");
	SpriteSheet board = new SpriteSheet( 800, 400, "Board.png");
	SpriteSheet power = new SpriteSheet( 20, 20, "up.png");
	SpriteSheet balli = new SpriteSheet( 20, 20, "ball.png");
	SpriteSheet playeri = new SpriteSheet( 12,50, "player.png");
	public Game()
	{
		for (int i = 0; i < 1; i ++){
		balls.add(new Ball(45));
		
		}
		for (int i = 0, j = 4;i < j; i ++){
			for (int o = 0, k = 6; o < k; o ++){
				blocks.add(new Blocks(20 +(i * 20),20 +(o * 60)));
			}
		}
		for (int i = 0, j = 4;i < j; i ++){
			for (int o = 0, k = 6; o < k; o ++){
				blockse.add(new Blocks(705 +(i * 20),20 +(o * 60)));
			}
		}
		
	}
	
	
	@SuppressWarnings("static-access")
	public void paint(Graphics g) 
	{
		super.paint(g);
		g.drawImage(board.getImage(0, 0), 0, 0,null);
		for (int i = 0; i < blocks.size(); i ++){
			g.drawImage(playeri.getImage(0,0), blocks.get(i).getX(),  blocks.get(i).getY(),null);
		}
		for (int i = 0; i < blocks.size(); i ++){
			g.drawImage(playeri.getImage(0,0), blocks.get(i).getX(),  blocks.get(i).getY(),null);
		}
		for (int i = 0; i < blockse.size(); i ++){
			g.drawImage(playeri.getImage(0,0), blockse.get(i).getX(),  blockse.get(i).getY(),null);
		}
		for (int i = 0; i < balls.size(); i ++){
			g.drawImage(balli.getImage(0, 0), balls.get(i).getX(),  balls.get(i).getY(),null);
		}
		for(int i = 0; i < ups.size(); i++){
			g.drawImage(power.getImage(0, 0), ups.get(i).getX(),  ups.get(i).getY(),null);
		}
		g.drawImage(playeri.getImage(0,0), player.getX(), player.getY(),null);
		g.drawImage(playeri.getImage(0,0),ai.getX(), ai.getY(),null);
		
		if(blocks.isEmpty()){
			g.drawImage(AIW.getImage(0,0), 0, 0,null);
		}
		if(blockse.isEmpty()){
			g.drawImage(PLW.getImage(0,0), 0, 0,null);
		}
		
		
		
		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	
	}
	
	public void update()
	{
		for (int j = 0; j < balls.size(); j ++)
		for( int i = 0; i < blocks.size(); i ++){
			if ((balls.get(j).getX() > blocks.get(i).getX() && balls.get(j).getX() < blocks.get(i).getX()+ 12)&&( balls.get(j).getY() >  blocks.get(i).getY()-20 && balls.get(j).getY() < blocks.get(i).getY()+50)){
				balls.get(j).hitX();
				if (p.spawn()){
					ups.add(new PowerUps(blocks.get(i).getX(),blocks.get(i).getY() ));
				}
				blocks.remove(i);
				
			}
		}
		for (int j = 0; j < balls.size(); j ++)
			for( int i = 0; i < blockse.size(); i ++){
				if ((balls.get(j).getX() > blockse.get(i).getX() && balls.get(j).getX() < blockse.get(i).getX()+ 12)&&( balls.get(j).getY() >  blockse.get(i).getY()-20 && balls.get(j).getY() < blockse.get(i).getY()+50)){
					balls.get(j).hitX();
					if (p.spawn()){
						ups.add(new PowerUps(blockse.get(i).getX(),blockse.get(i).getY() ));
					}
					blockse.remove(i);
					
				}
			}
		for ( int i = 0; i < ups.size(); i ++){
			ups.get(i). update();
			if ((ups.get(i).getX() > 88 && ups.get(i).getX() < 100)&&( ups.get(i).getY() > Player.getY()-20 && ups.get(i).getY() < Player.getY()+50)){
				ups.remove(i);
				balls.add(new Ball(45));
			}
			else if ((ups.get(i).getX() > 685-12 && ups.get(i).getX() < 685)&&( ups.get(i).getY() > AI.getY()-20 && ups.get(i).getY() < AI.getY()+50)){
				ups.remove(i);
				balls.add(new Ball(45));
			}
			else if (ups.get(i).dead()){
				ups.remove(i);
			}
		}
		player.update();
		ai.update();
		for (int i = 0; i < balls.size(); i ++){
			ai.checkBall(balls.get(i).getX(),balls.get(i).getY());
			balls.get(i).update();
		}
	repaint();
	}

	public  boolean menu(boolean a){
		boolean temp = menu;
		menu = a;
		return temp;
	}
	public static void gotoMenu(){
		menu = true;
	}
	public static void gotorestart(){
		restart = true;
	}
	public static boolean restart(boolean a){
		boolean temp = restart;
		restart = a;
		return temp;
	}
	
	
}
