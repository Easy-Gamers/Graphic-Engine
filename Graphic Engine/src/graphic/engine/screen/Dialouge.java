package graphic.engine.screen;

public class Dialouge extends Font {
	
	private static String[] message;
	private static int dialouge;
	private static int spaceChecker = 30;
	private static int defaultSpace = 30;
	private static int X = 144;
	private static int Y = 296;
	
	public static void setText(String[] message, int dialouge) {
		Dialouge.dialouge = dialouge;
		Dialouge.message = message;
	}
	
	public static boolean isEmpty() {
		return (message == null);
	}
	
	public static void setSpaceChecker(int characters) {
		defaultSpace = characters;
	}
	
	public static void setX(int x) {
		X = x;
	}
	
	public static void setY(int y) {
		Y = y;
	}
	
	public static void render(Screen screen, SpriteHandler sprite) {
		if(message == null)
			return;
		
		int x = X;
		int y = Y;
		spaceChecker = defaultSpace;
		message[dialouge] = message[dialouge].toUpperCase();
		int l = message[dialouge].length();
		for(int i = 0; i < l; i++) {
			int ch = letters.indexOf(message[dialouge].charAt(i));
			if(ch < 0) continue; {
				if(i == checkSpaces(message[dialouge], spaceChecker)) {
					spaceChecker += defaultSpace;
					x = X;
					y += 16;
				}
				screen.render(sprite.getSprites(ch % 60, ch / 60), x, y);
				x += 6; // 6 to 8
			}
		}
	}
	
	public static void render(Screen screen) {
		if(message == null)
			return;
		
		int x = X;
		int y = Y;
		spaceChecker = defaultSpace;
		message[dialouge] = message[dialouge].toUpperCase();
		int l = message[dialouge].length();
		for(int i = 0; i < l; i++) {
			int ch = letters.indexOf(message[dialouge].charAt(i));
			if(ch < 0) continue; {
				if(i == checkSpaces(message[dialouge], spaceChecker)) {
					spaceChecker += defaultSpace;
					x = X;
					y += 16;
				}
				screen.render(font.getSprites(ch % 60, ch / 60), x, y);
				x += 6; // 6 to 8
			}
		}
	}
	
	
	
}
