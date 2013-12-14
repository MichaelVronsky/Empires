package com.ugiveme.graphicsengine.spritesheet;

import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class SpriteSheet {

	public static BufferedImage loadImage(String url) {
		
		BufferedImage image = null;
		
		try {
			image = ImageIO.read(SpriteSheet.class.getResource("/" + url));
		} catch(Exception e) {
			e.printStackTrace();
		}

		return image;		
	}
	
	public static Image loadImage(String url, int x, int y, int width, int height) {
		
		BufferedImage image = null;
		
		try {
			image = loadImage(url);
			image = image.getSubimage(x, y, width, height);

		} catch(Exception e) {
			e.printStackTrace();
		}

		return image;
		
	}
	
	public static Image loadImage(String url, int x, int y, int width, int height, int scale) {
		
		return loadImage(url, x, y, width, height).getScaledInstance(width*scale, height*scale, BufferedImage.SCALE_DEFAULT);
		
	}
}
