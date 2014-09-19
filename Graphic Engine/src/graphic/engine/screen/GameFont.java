package graphic.engine.screen;

public class GameFont {
	
	public final static String bullet = "\u2022";
        public final static String pointer = "\u2265";
	
	static String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ                                  " + "0123456789-.!?/%$\\=*+,;:()&#\"'" + bullet + "    " + pointer + "                         ";
	
	public static int getLength(String message) {
		return message.length() * 12;
	}
	
	public static void render(String message, Screen screen, int x, int y){
		message = message.toUpperCase();
		int l = message.length();
		for(int i = 0; i < l; i++){
			int ch = letters.indexOf(message.charAt(i));
			if(ch < 0) continue;
				if(!message.contains(bullet) || !message.contains(pointer)) {
				screen.render(Art.getFont()[ch % 60][ch / 60], x, y);
				x += 7;
			} else {
                                    if(message.contains(bullet)) {
				screen.render(Art.getFont()[30][1], x, y);
				x += 8;
				screen.render(Art.getFont()[31][1], x, y);
				x += 8;
				screen.render(Art.getFont()[32][1], x, y);
				x -= 16;
				y += 8;
				screen.render(Art.getFont()[30][2], x, y);
				x += 8;
				screen.render(Art.getFont()[31][2], x, y);
				x += 8;
				screen.render(Art.getFont()[32][2], x, y);
				}
                                    if(message.contains(pointer)) {
                                        screen.render(Art.getFont()[35][1], x, y);
                                    }
                                //}
			}
		}
	}
	
	
	
}