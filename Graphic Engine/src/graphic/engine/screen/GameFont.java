package graphic.engine.screen;

public class GameFont extends Font {
	
	public final static String bullet = "\u2022";
    public final static String pointer = "\u2265";
	
	static String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ                                  " + "0123456789-.!?/%$\\=*+,;:()&#\"'" + bullet + "    " + pointer + "                         ";
	
	public static void render(String message, Screen screen, int x, int y, SpriteHandler sprite) {
		message = message.toUpperCase();
		int l = message.length();
		for(int i = 0; i < l; i++){
			int ch = letters.indexOf(message.charAt(i));
			if(ch < 0) continue;
				if(!message.contains(bullet) || !message.contains(pointer)) {
				screen.render(sprite.getSprites(ch % 60, ch / 60), x, y);
				x += 7;
			} else {
                if(message.contains(bullet)) {
					screen.render(sprite.getSprites(30, 1), x, y);
					x += 8;
					screen.render(sprite.getSprites(31, 1), x, y);
					x += 8;
					screen.render(sprite.getSprites(32, 1), x, y);
					x -= 16;
					y += 8;
					screen.render(sprite.getSprites(30, 2), x, y);
					x += 8;
					screen.render(sprite.getSprites(31, 2), x, y);
					x += 8;
					screen.render(sprite.getSprites(32, 2), x, y);
				}
                
                if(message.contains(pointer))
                	screen.render(sprite.getSprites(35, 1), x, y);
			}
		}
	}
	
	public static void render(String message, Screen screen, int x, int y) {
		message = message.toUpperCase();
		int l = message.length();
		for(int i = 0; i < l; i++){
			int ch = letters.indexOf(message.charAt(i));
			if(ch < 0) continue;
				if(!message.contains(bullet) || !message.contains(pointer)) {
				screen.render(font.getSprites(ch % 60, ch / 60), x, y);
				x += 7;
			} else {
                if(message.contains(bullet)) {
					screen.render(font.getSprites(30, 1), x, y);
					x += 8;
					screen.render(font.getSprites(31, 1), x, y);
					x += 8;
					screen.render(font.getSprites(32, 1), x, y);
					x -= 16;
					y += 8;
					screen.render(font.getSprites(30, 2), x, y);
					x += 8;
					screen.render(font.getSprites(31, 2), x, y);
					x += 8;
					screen.render(font.getSprites(32, 2), x, y);
				}
                
                if(message.contains(pointer))
                	screen.render(font.getSprites(35, 1), x, y);
			}
		}
	}
	
	
	
}