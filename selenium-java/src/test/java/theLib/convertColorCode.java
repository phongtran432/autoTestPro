package theLib;

public class convertColorCode {
	String hexColor;
	String colorCode;
	
	public convertColorCode(String colorCode){
		this.colorCode = colorCode;
	}
	
	public String convertColorToHex(){
		colorCode = colorCode.trim().toLowerCase();
		String[] numbers;
		if(colorCode.contains("a")){
			numbers = colorCode.replace("rgba(", "").replace(")", "").split(",");
		}else{
			numbers = colorCode.replace("rgb(", "").replace(")", "").split(",");
		}
		int r = Integer.parseInt(numbers[0].trim());
    	int g = Integer.parseInt(numbers[1].trim());
    	int b = Integer.parseInt(numbers[2].trim());
    	String hexColor = "#" + Integer.toHexString(r) + Integer.toHexString(g) + Integer.toHexString(b);
    	return hexColor;
	}
}
