package graphic.engine.screen;

//import me.zabuzasword3.engine.*;
//import me.zabuzasword3.engine.graphics.Bitmap;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.io.*;
import java.awt.image.*;

import javax.imageio.*;
//import me.zabuzasword3.engine.world.LevelMap;

public class Art {
	
    //public static Object game;
    private static Bitmap[][] spritesheet;
    private static Bitmap[][] font;
    private static Bitmap[][] buttons;
    private static Bitmap[][] minimap;
    private static Bitmap[][] map;
    private static Bitmap[][] icons;
    
    public static void setSpritesheet(String res, int w, int h, Object game) {
        spritesheet = cut(res, w, h, game);
    }
    
    public static Bitmap[][] getSpritesheet() {
        return spritesheet;
    }
    
    public static void setFont(String res, int w, int h, Object game) {
        font = cut(res, w, h, game);
    }
    
    public static Bitmap[][] getFont() {
        return font;
    }
    
    public static void setButtons(String res, int w, int h, Object game) {
        buttons = cut(res, w, h, game);
    }
    
    public static Bitmap[][] getButtons() {
        return buttons;
    }
    
    public static void setMinimap(String res, int w, int h, Object game) {
        minimap = cut(res, w, h, game);
    }
    
    public static Bitmap[][] getMinimap() {
        return minimap;
    }
    
    public static void setMap(String res, int w, int h, Object game) {
        map = cut(res, w, h, game);
    }
    
    public static Bitmap[][] getMap() {
        return map;
    }
    
    public static void setIcons(String res, int w, int h, Object game) {
        icons = cut(res, w, h, game);
    }
    
    public static Bitmap[][] getIcons() {
        return icons;
    }
//public static Bitmap[][] debugspritesheet = cut("/icon.png", 32, 32);
//	public static Bitmap[][] spritesheet = cut("/icon0.png", 32, 32);
//	public static Bitmap[][] font = cut("/8fontTest.png", 8, 8);
//	public static Bitmap[][] Buttons = cut("/button.png", 120, 20);
//        public static Bitmap[][] Minimap = cut("/map.png", 512, 512);
	
//	public static BufferedImage map(String res, Object game){
//		try {
//			// Load the BufferedImage
//			BufferedImage[] image = new BufferedImage[LevelMap.Maps.size()];//ImageIO.read(Destinyor.class.getResourceAsStream(res));
//			//image[LevelMap.level - 1] = ImageIO.read(game.class.getResourceAsStream(res));
//                        image[LevelMap.level - 1] = ImageIO.read(game.getClass().getResourceAsStream(res));
//                        
//                        int w = 512;
//                        int h = 512;
//                        
////			int w = image.getWidth();
////			int h = image.getHeight();
//			
//			// Create Bitmap
//			Bitmap result = new Bitmap(w, h);
//			
//			// Grab RGB Data from image using BufferedImage built in Method
//			image[LevelMap.level - 1].getRGB(0, 0, w * LevelMap.levelX, h * LevelMap.levelY, result.pixels, 0, w * LevelMap.levelX);
//			
//			return image[LevelMap.level - 1];
//			
//			} catch(Exception e){
//			e.printStackTrace();
//		}
//		return null;
//	}
    
    public static BufferedImage map(String res, int level, int w, int h, Object game){
		try {
			// Load the BufferedImage
			BufferedImage[] image = new BufferedImage[1];//ImageIO.read(Destinyor.class.getResourceAsStream(res));
			//image[LevelMap.level - 1] = ImageIO.read(game.class.getResourceAsStream(res));
                        image[level] = ImageIO.read(game.getClass().getResourceAsStream(res));
                        
//			int w = image.getWidth();
//			int h = image.getHeight();
			
			// Create Bitmap
			Bitmap result = new Bitmap(w, h);
			
			// Grab RGB Data from image using BufferedImage built in Method
			image[level].getRGB(0, 0, w, h, result.pixels, 0, w);
			
			return image[level];
			
			} catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	// Load Image than transform into Bitmap
	public static Bitmap load(String res, Object game){
		try {
			// Load the BufferedImage
			//BufferedImage image = ImageIO.read(Destinyor.class.getResourceAsStream(res));
                        BufferedImage image = ImageIO.read(game.getClass().getResourceAsStream(res));
			
			int w = image.getWidth();
			int h = image.getHeight();
			
			// Create Bitmap
			Bitmap result = new Bitmap(w, h);
			
			// Grab RGB Data from image using BufferedImage built in Method
			image.getRGB(0, 0, w, h, result.pixels, 0, w);
			
			return result;
			
			} catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	// load sprite sheet and split it
	public static Bitmap[][] cut(String res, int w, int h, Object game){
		try {
		//BufferedImage image = ImageIO.read(Destinyor.class.getResourceAsStream(res));
			InputStream input = game.getClass().getResourceAsStream(res);
                    //BufferedImage image = ImageIO.read(game.getClass().getResourceAsStream(res));
			BufferedImage image = ImageIO.read(input);
		
		int xt = image.getWidth() / w;
		int yt = image.getHeight() / h;
		
		Bitmap[][] result = new Bitmap[xt][yt];
		BufferedImage sub = null;
		for(int i = 0; i < xt; i++) {
			for(int j = 0; j < yt; j++){
				result[i][j] = new Bitmap(w, h);
				sub = image.getSubimage(i * w, j * h, w, h);
				sub.getRGB(0, 0, w, h, result[i][j].pixels, 0, w);
			}
		}
		input.close();
		input = null;
//		image.flush();
//		image = null;
//		sub.flush();
//		sub = null;
			return result;
		} catch(IOException e) {
			System.exit(1);
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static Bitmap[][] cut(int w, int h, String res){
		try {
		//BufferedImage image = ImageIO.read(Destinyor.class.getResourceAsStream(res));
			InputStream input = new FileInputStream(res);
                    //BufferedImage image = ImageIO.read(game.getClass().getResourceAsStream(res));
			BufferedImage image = ImageIO.read(input);
		
		int xt = image.getWidth() / w;
		int yt = image.getHeight() / h;
		
		Bitmap[][] result = new Bitmap[xt][yt];
		BufferedImage sub = null;
		for(int i = 0; i < xt; i++) {
			for(int j = 0; j < yt; j++){
				result[i][j] = new Bitmap(w, h);
				sub = image.getSubimage(i * w, j * h, w, h);
				sub.getRGB(0, 0, w, h, result[i][j].pixels, 0, w);
			}
		}
		input.close();
		input = null;
//		image.flush();
//		image = null;
//		sub.flush();
//		sub = null;
			return result;
		} catch(IOException e) {
			System.exit(1);
			e.printStackTrace();
		}
		
		return null;
	}
        
    public static Bitmap convert(BufferedImage image) {
            
    	Bitmap result = new Bitmap(image.getWidth(), image.getHeight());
            
           // BufferedImage sub = image.getSubimage(0, 0, image.getWidth(), image.getHeight());
    	image.getRGB(0, 0, image.getWidth(), image.getHeight(), result.pixels, 0, image.getWidth());
            
        return result;
    }
        
        public static BufferedImage getScaledInstance(BufferedImage img, int targetWidth, int targetHeight, RenderingHints.Key key, Object hint, boolean higherQuality) {
        int type = (img.getTransparency() == Transparency.OPAQUE) ?
            BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
        BufferedImage ret = (BufferedImage)img;
        int w, h;
        if (higherQuality) {
            // Use multi-step technique: start with original size, then
            // scale down in multiple passes with drawImage()
            // until the target size is reached
            w = img.getWidth();
            h = img.getHeight();
        } else {
            // Use one-step technique: scale directly from original
            // size to target size with a single drawImage() call
            w = targetWidth;
            h = targetHeight;
        }
        
        do {
            if (higherQuality && w <= targetWidth) {
                w /= 2;
                if (w <= targetWidth) {
                    w = targetWidth;
                }
            }

            if (higherQuality && h <= targetHeight) {
                h /= 2;
                if (h <= targetHeight) {
                    h = targetHeight;
                }
            }

            BufferedImage tmp = new BufferedImage(w, h, type);
            Graphics2D g2 = tmp.createGraphics();
            g2.setRenderingHint(key, hint);
            g2.drawImage(ret, 0, 0, w, h, null);
            g2.dispose();

            ret = tmp;
        } while (w != targetWidth || h != targetHeight);

        return ret;
    }
        
        public static BufferedImage convertSpritesheet(Bitmap bitmap, int w, int h, Object game) throws IOException {
        	Bitmap result = bitmap;
        	InputStream input = null;
        	BufferedImage image;
        	BufferedImage finalImage = null;
        	for(int i = 0; i < Art.getSpritesheet().length; i++) {
        		for(int j = 0; j < Art.getSpritesheet()[i].length; j++) {
        			if(result == Art.getSpritesheet()[i][j]) {
        				input = game.getClass().getResourceAsStream("/icon0.png");
        				image = ImageIO.read(input);
        				finalImage = image.getSubimage(i * w, j * h, w, h);
        				//spritesheet = cut("/icon0.png", w, h, game);
        			}
        		}
        	}
        	input.close();
        	input = null;
        	image = null;
        	return finalImage;
        }
        
        public static BufferedImage convertSpritesheet(Bitmap bitmap, Object game) throws IOException {
        	Bitmap result = bitmap;
        	InputStream input = null;
        	BufferedImage image;
        	BufferedImage finalImage = null;
        	for(int i = 0; i < Art.getSpritesheet().length; i++) {
        		for(int j = 0; j < Art.getSpritesheet()[i].length; j++) {
        			if(result == Art.getSpritesheet()[i][j]) {
        				input = game.getClass().getResourceAsStream("/icon0.png");
        				image = ImageIO.read(input);
        				finalImage = image.getSubimage(i * 32, j * 32, 32, 32);
        				//spritesheet = cut("/icon0.png", w, h, game);
        			}
        		}
        	}
        	input.close();
        	input = null;
        	image = null;
        	return finalImage;
        }

}
