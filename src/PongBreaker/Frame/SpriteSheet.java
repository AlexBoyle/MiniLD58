package PongBreaker.Frame;


import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class SpriteSheet {
	
	int column;
	BufferedImage img;
	BufferedImage img2;
	private  int WIDTH;
	private  int HEIGHT;
	
	/**
	 * 
	 */
	public SpriteSheet()
	{
		 WIDTH= 1;
		 HEIGHT= 1;
	}
	
	/**
	 * @param path : where is the image
	 */
	public SpriteSheet(String path)
	{
		try
		{
			img = ImageIO.read(getClass().getResource(path));
		}
		catch(IOException e) 
			{
			    
			}
		 WIDTH= 1;
		 HEIGHT= 1;
	}
	
	
	/**
	 * @precondition width and height > 0
	 * @param width : width of sprite
	 * @param height : height of sprite
	 * @param path : where is the image
	 */
	public SpriteSheet(int width, int height, String path)
	{
		if (width < 0 || height < 0)
			 throw new IllegalArgumentException("The WIDTH and HEIGHT can not be less than zero");
		WIDTH = width;
		HEIGHT = height;
		try
		{
			try{
			img = ImageIO.read(getClass().getResource(path));
			}
			catch(IllegalArgumentException e){
				
			}
		}
			catch(IOException e) 
			{
			    
			}
		
		
	}
	
	
	/**
	 * 
	 * @param c : coloum
	 * @param r : Row 
	 * @return BufferedImage
	 */
	public BufferedImage getImage(int c, int r){
		try{
		if (c < 0 || r < 0)
			 throw new IllegalArgumentException("The WIDTH and HEIGHT can not be less than zero");
		img2 = img.getSubimage( c * WIDTH, r * HEIGHT, WIDTH, HEIGHT);
		return img2;}
		catch(NullPointerException e){
			
		}
		return null;
	}
	
	
	/**
	 * 
	 * @param x : x positon of image
	 * @param y : y position of image
	 * @param w : how wide is the image
	 * @param h : how tall is the image
	 * @return BufferedImage
	 */
	public BufferedImage getCustom(int x, int y, int w, int h){
		img2 = img.getSubimage( x , y , w, h);
		return img2;
	}
	public void changeImage(String a)
	{
		
		try
		{
			img = ImageIO.read(getClass().getResource(a));
		}
		catch(IOException e) 
		{
		    
		}
		
	}
	
	
	/**
	 * 
	 * @param width : width of sprite
	 * @param height : height of sprite
	 */
	public void changeD(int width, int height)
	{
		if (WIDTH < 0 || HEIGHT < 0)
			 throw new IllegalArgumentException("The WIDTH and HEIGHT can not be less than zero");
		WIDTH = width;
		HEIGHT = height;
	}

}
