package PongBreaker.Entities;

public class AI {
	private static int x = 685;
	private static int y = 200;
	private int move = 0;
	
	private int speed = 3;
	public void checkBall(int xb, int yb){
		if(y - yb > 0){
			move = -1;
		}
		else{ move = 1;}
	}
	public static int getX(){
		return x;
	}
	public static int getY(){
		return y;
	}
	public void update(){
		
		y = y + (speed * move);
		if (y > 350){
			y -= speed;
		}
	}
}
