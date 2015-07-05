package PongBreaker.Entities;

public class Player {
	private int speed = 6;
	private static int change = 0;
	private static int x = 100;
	private static int y = 200;
	public Player(){
		x = 100;
		y = 200;
	}
public static int getX(){
	return x;
}
public static int getY(){
	return y;
}
public void update(){
	if (change == -1){
		if ( y < 0){
			
		}else {
		y -= speed;
	}}
	else if(change == 1){
		if ( y > 350){
			
		}else {
		y += speed;
	}}
}
public static void changeY(int a){
	change = a;
}
}
