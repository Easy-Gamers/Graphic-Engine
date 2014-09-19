package graphic.engine.screen;

public class Bitmap {
    
    public int w, h;
	public int[] pixels;
	
	public Bitmap(int w, int h) {
		this.w = w;
		this.h = h;
		
		this.pixels = new int[w * h];		
	}
}
