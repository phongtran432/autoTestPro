package theLib;

public class convertColorCode {
	String hexColor;
	
	public String convertColorToHex(String rgbCode){
		String[] numbers = rgbCode.replace("rgb(", "").replace(")", "").split(",");
    	int r = Integer.parseInt(numbers[0].trim());
    	int g = Integer.parseInt(numbers[1].trim());
    	int b = Integer.parseInt(numbers[2].trim());
    	String hexColor = "#" + Integer.toHexString(r) + Integer.toHexString(g) + Integer.toHexString(b);
		return hexColor;
	}
}