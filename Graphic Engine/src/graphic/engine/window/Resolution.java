package graphic.engine.window;


public class Resolution {
	
	private static int width = 1024;
	private static int height = 768;
        
        public static final int screenWidth = 1920;
        public static final int screenHeight = 1080;

	public static int width() {
		return width; 
	}
        
        public static int width(int scale) {
            return width / scale;
        }
	
	public static void setWidth(int w) {
		width = w;
	}
	
	public static int height() {
		return height; 
	}
        
        public static int height(int scale) {
            return height / scale;
        }
	
	public static void setHeight(int h) {
		height = h;
	}
	
//        public static int getScale() {
//            if(width / 16 * 9 == height)
//                return 16 * 9;
//                else if(width / 16 * 10 == height)
//                    return 16 * 10;
//                else if(width / 17 * 10 == height)
//                    return 17 * 10;
//                else if(width / 5 * 3 == height)
//                    return 5 * 3;
//                else if(width / 5 * 4 == height)
//                    return 5 * 4;
//                else return 12;
//            
//            //return 12;
//        }
        
//        public static int getScale() {
//            for(int i = 0; i < Options.Width; i++) {
//                for(int j = 0; j < Options.Height; j++) {
//                    if(Options.Height[i] == width / 3 * 4) {
//                        return 3;
//                    }
//                }
//            }
//        }
        
        public static int getScaleY() {
            for(int i = 0; i <= Height.length; i++) {
                if(Height[i] == height) {
                    return i;
                }
            }
            return 0;
        }
        
        public static int getScaleX() {
            for(int i = 0; i <= Width.length; i++) {
                if(Width[i] == width) {
                    return i;
                }
            }
            return 0;
        }
        
        public static int[] ResX = {
        3, 4, 4, 4, 4, 4, 4, 5, 5, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 17
    };
    
    public static int[] ResY = {
        4, 3, 3, 3, 3, 3, 3, 3, 4, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10
    };
    
    public static int[] Width = {
    	768,  800, 1024, 1152, 1280, 1400, 1600, 1280, 1280, 1093, 1280, 1311, 1360, 1366, 1600, 1920, 2048, 2560, 1280, 1440, 1680, 1920, 2560, 1024
    };
    
	public static int[] Height = 
	{
	768 / 3 * 4,
	800 / 4 * 3, 1024 / 4 * 3, 1152 / 4 * 3, 1280 / 4 * 3, 1400 / 4 * 3, 1600 / 4 * 3,
	1280 / 5 * 3, 
	1280 / 5 * 4,
	1093 / 16 * 9, 1280 / 16 * 9, 1311 / 16 * 9, 1360 / 16 * 9, 1366 / 16 * 9, 1600 / 16 * 9, 1920 / 16 * 9, 2048 / 16 * 9, 2560 / 16 * 9,
	1280 / 16 * 10, 1440 / 16 * 10, 1680 / 16 * 10, 1920 / 16 * 10, 2560 / 16 * 10, 
	1024 / 17 * 10
	};
    
    
    public static String[] Resolutions = 
    {
    "768 * " + Height[0], //3 * 4
    "800 * " + Height[1], "1024 * " + Height[2], "1152 * " + Height[3], "1280 * " + Height[4], "1400 * " + Height[5], "1600 * " + Height[6],  // 4 * 3
    "1280 * " + Height[7], // 5 * 3
    "1280 * " + Height[8],  // 5 * 4
    "1093 * " + Height[9], "1280 * " + Height[10], "1311 * " + Height[11], "1360 * " + Height[12], "1366 * " + Height[13],  "1600 * " + Height[14], "1920 * " + Height[15], "2048 * " + Height[16], "2560 * " + Height[17], // 16 * 9
    "1280 * " + Height[18], "1440 * " + Height[19], "1680 * " + Height[20], "1920 * " + Height[21], "2560 * " + Height[22],
    "1024 * " + Height[23]
    };
    
    public static String[] screenMode =
    {
    "Window",
    "Borderless Window",
    "Fullscreen"
    };
    
    public static boolean[] ResPicker = 
    {
    false, 
    true, false, false, false, false, false,
    false,
    false,
    false, false, false, false, false, false, false, false, false,
    false, false, false, false, false,
    false
    };
    
    public static boolean[] Window = 
    {
    true, false, false
    };
        
	public static int Scale = 4;
	
	public static String Fullscreen = "Window";
	
}
