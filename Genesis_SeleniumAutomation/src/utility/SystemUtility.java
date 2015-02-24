package utility;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class SystemUtility {

	

	/*This function cleans the string of special characters like "," and converts the (String)amount to Double value*/
	public static double cleanString(String value) throws Exception
	{
			NumberFormat number = NumberFormat.getInstance();
			Double numberValue = number.parse(value).doubleValue();
			return numberValue;
		
	}

    /*Method to round floating values to 2 decimal places using HALF_DOWN method*/
	public static double roundValue(double value) throws Exception
	{
		
		DecimalFormat df = new DecimalFormat("00.00");
		df.setRoundingMode(RoundingMode.HALF_DOWN);
		return cleanString(df.format(value));
		
	}
}
