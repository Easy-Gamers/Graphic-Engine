package graphic.engine.screen;

public class Font {
	
	private final static String bullet = "\u2022";
	
	protected static SpriteHandler font;
	
	public static String getBullet() {
		return bullet;
	}
	
	protected static String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ                                  " + "0123456789-.!?/%$\\=*+,;:()&#\"'" + bullet + "                             ";
	
	public static int getLength(String message) {
		return message.length() * 12;
	}
	
	protected static int checkSpaces(String message, int l) {
		for(int i = 0; i < message.length(); i++) {
			if(i >= l) {
				if(message.charAt(i - 1) == ' ') {
					return i;
				}
			}
		}
		return 0;
	}
	
	public static void setFont(SpriteHandler font) {
		Font.font = font;
	}
	
}
