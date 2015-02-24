package utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.itextpdf.text.pdf.PdfPCell;

public class DataValues {
	
	public static String testResult = "TRUE";
	public static Integer testPassCount = 0;
	public static Integer testFailCount = 0;
	public static Integer testSkipCount = 0;
	public static Integer totalTests = 0;
	public static PdfPCell globalCell= new PdfPCell();
	
	static SimpleDateFormat formatter =new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss");
	static Date date = new Date();
	public static String testDate  = formatter.format(date);

}
