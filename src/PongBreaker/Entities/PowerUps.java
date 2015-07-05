package PongBreaker.Entities;

import java.util.Random;

public class PowerUps {
	private int direction = 0;
	private int speed = 3;
	Random r = new Random();
	int x = 0;
	boolean dead = false;
	int y = 0;
	public PowerUps(){
		
	}
	public PowerUps(int x1, int y1){
		this.x = x1;
		this.y = y1;
		if ( x > 400){
			direction = -1;
		}
		else{ 
			direction = 1;
		}
	}
	public boolean spawn(){
		if (r.nextInt(8) == 4){
			return true;
		}
	return false;
	}
	public void update(){
		x += speed * direction;
	}
	public boolean dead(){
		if ( x < 0 || x > 800){
			dead = true;
		}
		return dead;
	}
	public int getX() {
		
		return x;
	}
	public int getY(){
		return y;
	}
}

