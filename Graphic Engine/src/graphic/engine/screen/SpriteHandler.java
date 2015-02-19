package graphic.engine.screen;

public class SpriteHandler extends Art {
	
	private Bitmap[][] spritesheet;
	
	private String res;
	
	public SpriteHandler(String res, int w, int h, Object game) {
		spritesheet = set(res, w, h, game);
		this.res = res;
	}
	
	public SpriteHandler(String res, int w, int h) {
		spritesheet = set(res, w, h);
	}
    
    public Bitmap getSprites(int i, int j) {
        return spritesheet[i][j];
    }
    
    public int getLength() {
    	return spritesheet.length;
    }
    
    public int getLength(int i) {
    	return spritesheet[i].length;
    }
    
    public String getRes() {
    	return res;
    }
	
    public Bitmap[][] getSpritesheet() {
    	return spritesheet;
    }
    
}
