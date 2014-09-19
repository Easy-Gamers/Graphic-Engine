package graphic.engine.screen;

public class Dialouge {
	
	public static String bullet = "\u2022";
	
	private static String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ                                  " + "0123456789-.!?/%$\\=*+,;:()&#\"'" + bullet + "                             ";
	private static String space = " ";
	public static int getLength(String message) {
		return message.length() * 12;
	}
	
	private static String[] message;
	private static int dialouge;
	
	public static void setText(String[] message, int dialouge) {
		Dialouge.dialouge = dialouge;
		Dialouge.message = message;
	}
	
	public static boolean isEmpty() {
		if(message == null) {
			return false;
		} else {
			return true;
		}
	}
	
	public static void render(Screen screen) {
		if(message == null)
			return;
//		int x = 130;
//		int y = 300;
		//int lines = 1;
		int x = 144;
		int y = 296;
		int spacechecker = 30;
		message[dialouge] = message[dialouge].toUpperCase();
		int l = message[dialouge].length();
		for(int i = 0; i < l; i++) {
			int ch = letters.indexOf(message[dialouge].charAt(i));
			if(ch < 0) continue; {
				if(i == checkSpaces(message[dialouge], spacechecker)) {
					spacechecker += 30;
					x = 144;
					y += 16;
					//y = 1920 / 10;
					//x = 1080 / 7;
//				} else {
//					if(i >= 30) {
//						spacechecker++;
//					}
				}
				
//				if(i == lines * 50) {
//					lines++;
//					y += 16;
//				}
				screen.render(Art.getFont()[ch % 60][ch / 60], x, y);
				x += 6; // 6 to 8
			}
		}
	}
	
//	public static void render(Screen screen, String[] message, int dialouge){
////		int x = 130;
////		int y = 300;
//		//int lines = 1;
//		int x = 144;
//		int y = 296;
//		int spacechecker = 30;
//		message[dialouge] = message[dialouge].toUpperCase();
//		int l = message[dialouge].length();
//		for(int i = 0; i < l; i++) {
//			int ch = letters.indexOf(message[dialouge].charAt(i));
//			if(ch < 0) continue; {
//				if(i == checkSpaces(message[dialouge], spacechecker)) {
//					spacechecker += 30;
//					x = 144;
//					y += 16;
//					//y = 1920 / 10;
//					//x = 1080 / 7;
////				} else {
////					if(i >= 30) {
////						spacechecker++;
////					}
//				}
//				
////				if(i == lines * 50) {
////					lines++;
////					y += 16;
////				}
//				screen.render(Art.getFont()[ch % 60][ch / 60], x, y);
//				x += 6; // 6 to 8
//			}
//		}
//	}
	
	private static int checkSpaces(String message, int l) {
		for(int i = 0; i < message.length(); i++) {
			if(i >= l) {
				if(message.charAt(i - 1) == space.charAt(0)) {
					return i;
				}
			}
		}
		return 0;
	}
	
}
