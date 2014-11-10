package graphic.engine.screen;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

public class Art {
	
    private static Bitmap[][] spritesheet;
    private static Bitmap[][] font;
    private static Bitmap[][] buttons;
    private static Bitmap[][] minimap;
    private static Bitmap[][] map;
    private static Bitmap[][] icons;
    private static Bitmap[][] scrollbars;
    
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
    
    public static void setScrollbars(String res, int w, int h, Object game) {
    	scrollbars = cut(res, w, h, game);
    }
    
    public static Bitmap[][] getScrollbars() {
    	return scrollbars;
    }
    
    /**
     * 
     * @param res
     * @param level
     * @param w
     * @param h
     * @param game
     * @return
     */
    public static BufferedImage map(String res, int level, int w, int h, Object game){
		try {
			// Load the BufferedImage
			BufferedImage[] image = new BufferedImage[1];
			
            image[level] = ImageIO.read(game.getClass().getResourceAsStream(res));
			
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
    
    /**
     * Load Image than transform into Bitmap
     * @param res
     * @param game
     * @return
     */
	public static Bitmap load(String res, Object game){
		try {
			// Load the BufferedImage
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
	
	/**
	 * load sprite sheet and split it
	 * @param res
	 * @param w
	 * @param h
	 * @param game
	 * @return
	 */
	public static Bitmap[][] cut(String res, int w, int h, Object game){
		try {
			InputStream input = game.getClass().getResourceAsStream(res);
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
		image.flush();
		sub.flush();
		input = null;
		
			return result;
		} catch(IOException e) {
			System.exit(1);
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * load sprite sheet and split it
	 * @param w
	 * @param h
	 * @param res
	 * @return
	 */
	public static Bitmap[][] cut(int w, int h, String res){
		try {
			InputStream input = new FileInputStream(res);
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
		image.flush();
		sub.flush();
		input.close();
		input = null;
			return result;
		} catch(IOException e) {
			System.exit(1);
			e.printStackTrace();
		}
		
		return null;
	}
       
	/**
	 * 
	 * @param image
	 * @return
	 */
    public static Bitmap convert(BufferedImage image) {
            
    	Bitmap result = new Bitmap(image.getWidth(), image.getHeight());
    	
    	image.getRGB(0, 0, image.getWidth(), image.getHeight(), result.pixels, 0, image.getWidth());
    	
        image.flush();
        return result;
    }
        
    /**
     * 
     * @param img
     * @param targetWidth
     * @param targetHeight
     * @param key
     * @param hint
     * @param higherQuality
     * @return
     */
        public static BufferedImage getScaledInstance(BufferedImage img, int targetWidth, int targetHeight, RenderingHints.Key key, Object hint, boolean higherQuality) {
        int type = (img.getTransparency() == Transparency.OPAQUE) ? BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
        
        BufferedImage ret = (BufferedImage) img;
        
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
        img.flush();
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
            
            tmp.flush();
        } while (w != targetWidth || h != targetHeight);

        return ret;
    }
        /**
         * 
         * @param bitmap
         * @param w
         * @param h
         * @param game
         * @return
         * @throws IOException
         */
        public static BufferedImage convertSpritesheet(Bitmap bitmap, int w, int h, Object game) throws IOException {
        	Bitmap result = bitmap;
        	InputStream input = null;
        	BufferedImage image = null;
        	BufferedImage finalImage = null;
        	for(int i = 0; i < Art.getSpritesheet().length; i++) {
        		for(int j = 0; j < Art.getSpritesheet()[i].length; j++) {
        			if(result == Art.getSpritesheet()[i][j]) {
        				input = game.getClass().getResourceAsStream("/icon0.png");
        				image = ImageIO.read(input);
        				finalImage = image.getSubimage(i * w, j * h, w, h);
        			}
        		}
        	}
        	if(image != null)
        	image.flush();
        	input.close();
        	input = null;
        	image = null;
        	return finalImage;
        }
        
        /**
         * 
         * @param bitmap
         * @param game
         * @return
         * @throws IOException
         */
        public static BufferedImage convertSpritesheet(Bitmap bitmap, Object game) throws IOException {
        	Bitmap result = bitmap;
        	InputStream input = null;
        	BufferedImage image = null;
        	BufferedImage finalImage = null;
        	for(int i = 0; i < Art.getSpritesheet().length; i++) {
        		for(int j = 0; j < Art.getSpritesheet()[i].length; j++) {
        			if(result == Art.getSpritesheet()[i][j]) {
        				input = game.getClass().getResourceAsStream("/icon0.png");
        				image = ImageIO.read(input);
        				finalImage = image.getSubimage(i * 32, j * 32, 32, 32);
        			}
        		}
        	}
        	if(image != null)
        	image.flush();
        	input.close();
        	input = null;
        	image = null;
        	return finalImage;
        }

}
