package graphic.engine.window;

import java.awt.Dimension;


public class Resolution {
	
	private static int width = 1024;
	private static int height = 768;

	public static int width() {
		return width; 
	}
	
	public static void setWidth(int w) {
		width = w;
	}
	
	public static int height() {
		return height; 
	}
	
	public static void setHeight(int h) {
		height = h;
	}
	
	/**
	 * Returns the array index value of the current resolution
	 * @return array index value of current resolution
	 */
	public static int getResolutionInt() {
		String width = Integer.toString(width());
		String height = Integer.toString(height());
//		for(int i = 0; i < Resolutions.length; i++) {
//			if(Resolutions[i].equals(width + " * " + height)) {
//				return i;
//			}
//		}
		return getResolutionInt(width + " * " + height);
	}
	
	/**
	 * Returns the array index value of the current resolution
	 * @param res Resolution to find the array index value of.
	 * @return array index value of the resolution inputed
	 */
	public static int getResolutionInt(String res) {
		for(int i = 0; i < Resolutions.length; i++) {
			if(Resolutions[i].equals(res)) {
				return i;
			}
		}
		return 0;
	}
	
	public static Dimension getResolution() {
		return new Dimension(width(), height());
	}
    
    public static int[] Width = {
    	768,  
    	800, 1024, 1152, 1280, 1400, 1600,
    	1280,
    	1280, 
    	1093, 1280, 1311, 1360, 1366, 1600, 1920, 2048, 2560,
    	1280, 1440, 1680, 1920, 2560, 
    	1024
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
    Width[0] + " * " + Height[0], //3 * 4
    "800 * " + Height[1], "1024 * " + Height[2], "1152 * " + Height[3], "1280 * " + Height[4], "1400 * " + Height[5], "1600 * " + Height[6],  // 4 * 3
    "1280 * " + Height[7], // 5 * 3
    "1280 * " + Height[8],  // 5 * 4
    "1093 * " + Height[9], "1280 * " + Height[10], "1311 * " + Height[11], "1360 * " + Height[12], "1366 * " + Height[13],  "1600 * " + Height[14], "1920 * " + Height[15], "2048 * " + Height[16], "2560 * " + Height[17], // 16 * 9
    "1280 * " + Height[18], "1440 * " + Height[19], "1680 * " + Height[20], "1920 * " + Height[21], "2560 * " + Height[22],
    "1024 * " + Height[23]
    };
        
    public static final String WINDOW = "Window", B_WINDOW = "Borderless Window", FULLSCREEN = "Fullscreen";
    
	public static int Scale = 4;
	
	public static String Fullscreen = WINDOW;
	
}
