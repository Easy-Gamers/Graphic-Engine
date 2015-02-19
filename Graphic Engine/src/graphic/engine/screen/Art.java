package graphic.engine.screen;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

public class Art {
    
    protected static Bitmap[][] set(String res, int w, int h, Object game) {
    	return cut(res, w, h, game);
    }
    
    protected static Bitmap[][] set(String res, int w, int h) {
    	return cut(res, w, h);
    }
    

	private static BufferedImage flush(BufferedImage image) {
		image.flush();
		image = null;
		return image;
	}
	
	private static InputStream close(InputStream input) throws IOException {
		input.close();
		input = null;
		return input;
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
	protected static Bitmap load(String res, Object game){
		try {
			// Load the BufferedImage
            BufferedImage image = ImageIO.read(game.getClass().getResourceAsStream(res));
			
			int w = image.getWidth();
			int h = image.getHeight();
			
			// Create Bitmap
			Bitmap result = new Bitmap(w, h);
			
			// Grab RGB Data from image using BufferedImage built in Method
			image.getRGB(0, 0, w, h, result.pixels, 0, w);
			image = flush(image);
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
	private static Bitmap[][] cut(String res, int w, int h, Object game){
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
		input = close(input);
		image = flush(image);
		sub = flush(sub);
		
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
	private static Bitmap[][] cut(String res, int w, int h){
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
		input = close(input);
		image = flush(image);
		sub = flush(sub);
		
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
	 * @return Bitmap
	 */
    public static Bitmap convert(BufferedImage image) {
            
    	Bitmap result = new Bitmap(image.getWidth(), image.getHeight());
    	
    	image.getRGB(0, 0, image.getWidth(), image.getHeight(), result.pixels, 0, image.getWidth());
    	
        image = flush(image);
        return result;
    }
    
    public static Bitmap getAndConvert(String res, int width, int height, boolean higherQuality) {
    	try {
			InputStream input = new FileInputStream(res);
			BufferedImage image = ImageIO.read(input);
			
			BufferedImage finalBuffer = getScaledInstance(image, width, height, RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR, higherQuality);
			
			Bitmap picture = convert(finalBuffer);
			input = close(input);
			image = flush(image);
			finalBuffer = flush(finalBuffer);
			return picture;
			
    	} catch(IOException e) {
    		System.out.println("Error getting the image");
			System.exit(1);
			e.printStackTrace();
		}
		
		return null;
    }
    
    public static Bitmap getAndConvert(InputStream input, int width, int height, boolean higherQuality) {
    	try {
			BufferedImage image = ImageIO.read(input);
			
			BufferedImage finalBuffer = getScaledInstance(image, width, height, RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR, higherQuality);
			
			Bitmap picture = convert(finalBuffer);
			input = close(input);
			image = flush(image);
			finalBuffer = flush(finalBuffer);
			return picture;
		
		} catch(IOException e) {
			System.out.println("Error getting the image");
			System.exit(1);
			e.printStackTrace();
		}
		
		return null;
    }
    
    public static Bitmap getAndConvert(InputStream input, int scale, boolean higherQuality) {
    	try {
			BufferedImage image = ImageIO.read(input);
			int width;
			int height;
			
			if(scale >= 0) {
				width = image.getWidth() * scale;
				height = image.getHeight() * scale;
			} else {
				width = image.getWidth() / (scale * -1);
				height = image.getHeight() / (scale * -1);
			}
			BufferedImage finalBuffer = getScaledInstance(image, width, height, RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR, higherQuality);
			
			Bitmap picture = convert(finalBuffer);
			input = close(input);
			image = flush(image);
			finalBuffer = flush(finalBuffer);
			return picture;
		
		} catch(IOException e) {
			System.out.println("Error getting the image");
			System.exit(1);
			e.printStackTrace();
		}
		
		return null;
    }
    
    public static Bitmap get(InputStream input) {
    	BufferedImage image;
		try {
			image = ImageIO.read(input);
			Bitmap picture = convert(image);
			
			input = close(input);
			image = flush(image);
			
	    	return picture;
		} catch (IOException e) {
			System.out.println("Error getting the image");
			System.exit(1);
			e.printStackTrace();
		}
    	return null;
    }
    
    public static Bitmap get(String res) {
    	InputStream input;
		try {
			input = new FileInputStream(res);
			BufferedImage image = ImageIO.read(input);
			Bitmap picture = convert(image);
			
			input = close(input);
			image = flush(image);
			
			return picture;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }
    
    public static BufferedImage getImage(InputStream input) {
    	BufferedImage image;
		try {
			image = ImageIO.read(input);
			
			input = close(input);
			
	    	return image;
		} catch (IOException e) {
			System.out.println("Error getting the image");
			System.exit(1);
			e.printStackTrace();
		}
    	return null;
    }
    
    public static BufferedImage getImage(String res) {
    	InputStream input;
		try {
			input = new FileInputStream(res);
			BufferedImage image = ImageIO.read(input);
			
			input = close(input);
			
			return image;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }
        
    /**
     * 
     * @param img
     * @param targetWidth
     * @param targetHeight
     * @param key
     * @param hint
     * @param higherQuality
     * @return zoomed in
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
        img = flush(img);
        do {
            if (higherQuality && w > targetWidth) {
                w /= 2;
                if (w < targetWidth) {
                    w = targetWidth;
                }
            }
//            } else if(higherQuality && w <= targetWidth) {
//            	w *= 2;
//                if (w >= targetWidth) {
//                    w = targetWidth;
//                }
//            }

            if (higherQuality && h > targetHeight) {
                h /= 2;
                if (h < targetHeight) {
                    h = targetHeight;
                }
            }
//            } else if(higherQuality && w <= targetHeight) {
//            	h *= 2;
//                if (h >= targetHeight) {
//                    h = targetHeight;
//                }
//            }

            BufferedImage tmp = new BufferedImage(w, h, type);
            Graphics2D g2 = tmp.createGraphics();
            g2.setRenderingHint(key, hint);
            g2.drawImage(ret, 0, 0, w, h, null);
            g2.dispose();

            ret = tmp;
            
            //tmp = flush(tmp);
        } while (w != targetWidth || h != targetHeight);
        //tmp = flush(tmp);
        return ret;
    }
        
        /**
         * 
         * @param bitmap
         * @param w
         * @param h
         * @param game
         * @param sprite
         * @return BufferedImage
         * @throws IOException
         */
        public static BufferedImage convert(Bitmap bitmap, int w, int h, Object game, SpriteHandler sprite) throws IOException {
        	Bitmap result = bitmap;
        	InputStream input = null;
        	BufferedImage image = null;
        	BufferedImage finalImage = null;
        	for(int i = 0; i < sprite.getLength(); i++) {
        		for(int j = 0; j < sprite.getLength(i); j++) {
        			if(result == sprite.getSprites(i, j)) {
        				input = game.getClass().getResourceAsStream(sprite.getRes());
        				image = ImageIO.read(input);
        				finalImage = image.getSubimage(i * w, j * h, w, h);
        			}
        		}
        	}
        	if(image != null)
        		image = flush(image);
        	input = close(input);
        	return finalImage;
        }

}
