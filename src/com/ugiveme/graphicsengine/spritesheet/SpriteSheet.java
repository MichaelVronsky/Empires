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
	
	public static Image loadImage(String url, int scale) {
		Image image = loadImage(url);
		return image.getScaledInstance(image.getWidth(null)*scale, image.getHeight(null)*scale, BufferedImage.SCALE_DEFAULT);
	}
	
	public static Image[][] loadImages(String url, int width, int height, int numH, int numV, int scale) {
		
		BufferedImage image = loadImage(url);
		
		Image[][] images = new Image[numH][numV];
		
		for (int i=0;i<numH;i++) {
			for (int k=0;k<numV;k++) {
				System.out.println("doing " + (i*height) + " " + k);

				images[i][k] = image.getSubimage(k*width, i*height, width, height).getScaledInstance(width*scale, height*scale, BufferedImage.SCALE_DEFAULT);
			}
		}
		
		return images;
		
	}
}
