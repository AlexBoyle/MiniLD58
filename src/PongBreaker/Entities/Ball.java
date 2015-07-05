package PongBreaker.Entities;

import java.util.Random;

public class Ball {
	Random r = new Random();
	
	int x = 450, y = 200;
	public int speed = 6;
	int speedX = 0, speedY = 0;
	 int direction = 10;
	public Ball(int a){
		
		direction = a - r.nextInt(30);
		
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void hitX(){
		direction = 90-(direction - 90) ;
	}
	
	
	public void update(){
		 if ((x > 685-12 && x < 685)&&( y > AI.getY()-20 && y < AI.getY()+50)){
			 direction = 90-((direction - 90));
	
		 }
		
		
		
		 if ( x <= 0){
			 direction = 90-(direction - 90);
			 
		 }
		 if ( x >= 800){
			 direction = 90-(direction - 90);
			 
		 }
		 if ( y <= 0){
			 direction = 360 - direction;
			 
		 }
		 if ( y >= 400){
			 direction = 360 - direction;
			 
		 }
		
		 if ((x > 88 && x < 100)&&( y > Player.getY()-20 && y < Player.getY()+50)){
			 direction = 90-((direction - 90) + r.nextInt(30)-15);
	
		 }
		 
		
		
		 speedX = (int)(speed * Math.cos(Math.toRadians(direction)));
	      speedY = (int)(-speed * (float)Math.sin(Math.toRadians(direction)));
		x += speedX;
		y += speedY;
		
	}
}
