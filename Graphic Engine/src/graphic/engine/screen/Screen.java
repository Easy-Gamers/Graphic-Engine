package graphic.engine.screen;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Screen {
    
    public BufferedImage image;
    //public BufferedImage cutscene;
	
	public int w, h;
	
	public int[] pixels;
	//public int[] cPixels;
	//public double[] pPixels;
	//public int[] npcPixels;
	
	
	public Screen(int w, int h) {
		this.w = w;
		this.h = h;
		
		image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		//cutscene = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		
		pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
		//npcPixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
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
        
//        public void renderCutscene(Bitmap bitmap, int x, int y) {
//    		// Take the 4 corners of the screen
//    		int x0 = x;
//    		int x1 = x + bitmap.w;
//    		int y0 = y;
//    		int y1 = y + bitmap.h;
//    		
//    		// Adjust the boundaries
//    		if(x0 < 0) {
//    			x0 = 0;
//    		}
//    		
//    		if(x1 > w){
//    			x1 = w;
//    		}
//    		
//    		if(y0 < 0){
//    			y0 = 0;
//    		}
//    		
//    		if(y1 > h){
//    			y1 = h;
//    		}
//    		
//    		// aw = Actual Width
//    		int aw = x1 - x0;
//    		
//    		// Render to BufferedImage
//    		for(int i = y0; i < y1; i++) {
//    			int tp = i * w + x0;
//    			int sp = (i - y) * bitmap.w + (x0 - x);
//    			tp -= sp;
//    			
//    			for(int j = sp; j < sp + aw; j++) {
//    				int col = bitmap.pixels[j];
//    				
//    				if(col < 0) {
//    					cPixels[tp + j] = col;
//    				}
//    			}
//    		}
//    	}
}
