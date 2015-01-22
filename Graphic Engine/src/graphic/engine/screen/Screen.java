package graphic.engine.screen;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Screen {
    
    public BufferedImage image;
    //public BufferedImage cutscene;
	
	private int w, h;
	
	private static int width = 0, height = 0;
	
	public int[] pixels;
	//public int[] cPixels;
	//public double[] pPixels;
	//public int[] npcPixels;
	
	/**
	 * 
	 * @param w
	 * @param h
	 */
	public Screen(int w, int h) {
		this.w = w;
		this.h = h;
		if(!(width > 0)) {
			width = w;
		}
		if(!(height > 0)) {
			height = h;
		}
		
		image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		
		pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
		// In this line you are not creating a new object.
		// You are storing a reference to the object int[] in your variable pixels.
		// Anything you change in pixels, gets changed inside of the int[] object in image.
	}
	
	// Alternative to g.DrawImage
	public void render(Bitmap bitmap, int x, int y) {
		// Take the 4 corners of the screen
		int x0 = x;
		int x1 = x + bitmap.w;
		int y0 = y;
		int y1 = y + bitmap.h;
		
		// Adjust the boundaries
		if(x0 < 0) {
			x0 = 0;
		}
		
		if(x1 > w){
			x1 = w;
		}
		
		if(y0 < 0){
			y0 = 0;
		}
		
		if(y1 > h){
			y1 = h;
		}
		
		// aw = Actual Width
		int aw = x1 - x0;
		
		// Render to BufferedImage
		for(int i = y0; i < y1; i++) {
			int tp = i * w + x0;
			int sp = (i - y) * bitmap.w + (x0 - x);
			tp -= sp;
			
			for(int j = sp; j < sp + aw; j++) {
				int col = bitmap.pixels[j];
				
				if(col < 0) {
					pixels[tp + j] = col;
				}
			}
		}
	}
        
        public void renderMap(Bitmap bitmap, int x, int y) {
		// Take the 4 corners of the screen
		int x0 = x;
		int x1 = x + bitmap.w;
		int y0 = y;
		int y1 = y + bitmap.h;
		
		// Adjust the boundaries
		if(x0 < 0) {
			x0 = 0;
		}
		
		if(x1 > w){
			x1 = w;
		}
		
		if(y0 < 0){
			y0 = 0;
		}
		
		if(y1 > h){
			y1 = h;
		}
		
		// aw = Actual Width
		int aw = x1 - x0;
		
		// Render to BufferedImage
		for(int i = y0; i < y1; i++) {
			int tp = i * w + x0;
			int sp = (i - y) * bitmap.w + (x0 - x);
			tp -= sp;
			
			for(int j = sp; j < sp + aw; j++) {
				int col = bitmap.pixels[j];
				
				if(col < 0) {
					pixels[tp + j] = col;
				}
			}
		}
	}
        
        public static int getWidth() {
        	return width;
        }
        
        public static int getHeight() {
        	return height;
        }
        
        public int getThisWidth() {
        	return w;
        }
        
        public int getThisHeight() {
        	return h;
        }
}
