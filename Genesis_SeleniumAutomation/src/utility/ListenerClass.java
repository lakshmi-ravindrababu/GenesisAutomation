package utility;

import java.io.FileOutputStream;
import java.util.Date;
import org.testng.ITestContext;
import org.testng.ITestResult;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import org.testng.TestListenerAdapter;
import com.itextpdf.text.FontFactory;

public class ListenerClass extends TestListenerAdapter {
	
	private Document document = null;
	
	
	PdfPTable successTable = null, failTable = null , skipTable = null,reportTable = null;	
	
	public ListenerClass() {
				
		this.document = new Document();
		
	}
	
	public void onTestSuccess(ITestResult result) {
		//log("onTestSuccess("+result+")");
		
	
		
		if (successTable == null) {
			this.successTable = new PdfPTable(new float[]{.3f, .3f, .1f});
			Paragraph p = new Paragraph("PASSED TESTS", new Font(Font.FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD));
			p.setAlignment(Element.ALIGN_CENTER);
			PdfPCell cell = new PdfPCell(p);
			cell.setColspan(4);
			cell.setBackgroundColor(BaseColor.GREEN);
			
			this.successTable.addCell(cell);
			
			cell = new PdfPCell(new Paragraph("TestCase"));
			cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			this.successTable.addCell(cell);
			cell = new PdfPCell(new Paragraph("Method"));
			cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			this.successTable.addCell(cell);
			cell = new PdfPCell(new Paragraph("Time (ms)"));
			cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			this.successTable.addCell(cell);
		
		}
		
		String temp = result.getTestClass().toString().replaceAll("TestClass name=class", "").replace("[", "").replace("]", "");
		PdfPCell cell = new PdfPCell(new Paragraph(temp.replaceAll("automationFramework.", "").replaceAll("_TestCase", "")));
		this.successTable.addCell(cell);
		cell = new PdfPCell(new Paragraph(result.getMethod().toString().replaceAll("\\[(.*?)\\]", "")));
		this.successTable.addCell(cell);
		cell = new PdfPCell(new Paragraph("" + (result.getEndMillis()-result.getStartMillis())));
		this.successTable.addCell(cell);

	
	}

	
	public void onTestFailure(ITestResult result) {
	//	log("onTestFailure("+result+")");
		
	
		
		if (this.failTable == null) {
			this.failTable = new PdfPTable(new float[]{.3f, .3f, .1f});
			this.failTable.setTotalWidth(20f);
			Paragraph p = new Paragraph("FAILED TESTS", new Font(Font.FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD));
			p.setAlignment(Element.ALIGN_CENTER);
			PdfPCell cell = new PdfPCell(p);
			cell.setColspan(4);
			cell.setBackgroundColor(BaseColor.RED);
			this.failTable.addCell(cell);
			
			cell = new PdfPCell(new Paragraph("TestCase"));
			cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			this.failTable.addCell(cell);
			cell = new PdfPCell(new Paragraph("Method"));
			cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			this.failTable.addCell(cell);
			cell = new PdfPCell(new Paragraph("Time (ms)"));
			cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			this.failTable.addCell(cell);
			
		}
		
		if(this.reportTable==null){
			
			this.reportTable = new PdfPTable(new float[]{.2f, .2f, .3f});
			this.reportTable.setTotalWidth(PageSize.A4.getWidth()-10);
		    this.reportTable.setLockedWidth(true);
			Paragraph p = new Paragraph("FAILED TEST DETAILED REPORT", new Font(Font.FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD));
			p.setAlignment(Element.ALIGN_CENTER);
			PdfPCell cell = new PdfPCell(p);
			cell.setColspan(4);
			cell.setBackgroundColor(BaseColor.RED);
			this.reportTable.addCell(cell);
			
			cell = new PdfPCell(new Paragraph("TestCase"));
			cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			this.reportTable.addCell(cell);
			cell = new PdfPCell(new Paragraph("Method"));
			cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			this.reportTable.addCell(cell);
			cell = new PdfPCell(new Paragraph("Details"));
			cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			this.reportTable.addCell(cell);
			
			
		}
		
		String temp = result.getTestClass().toString().replaceAll("TestClass name=class", "").replace("[", "").replace("]", "");
	
		PdfPCell cell = new PdfPCell(new Paragraph(temp.replaceAll("automationFramework.", "").replaceAll("_TestCase", "")));
		this.failTable.addCell(cell);
				cell = new PdfPCell(new Paragraph(result.getMethod().toString().replaceAll("\\[(.*?)\\]", "")));
		this.failTable.addCell(cell);
		cell = new PdfPCell(new Paragraph("" + (result.getEndMillis()-result.getStartMillis())));
		this.failTable.addCell(cell);
		
		temp = result.getTestClass().toString().replaceAll("TestClass name=class", "").replace("[", "").replace("]", "");
		
		cell = new PdfPCell(new Paragraph(temp.replaceAll("automationFramework.", "").replaceAll("_TestCase", "")));
		 
		this.reportTable.addCell(cell);
		cell = new PdfPCell(new Paragraph(result.getMethod().toString().replaceAll("\\[(.*?)\\]", "")));
		this.reportTable.addCell(cell);
		this.reportTable.addCell(DataValues.globalCell);
		DataValues.globalCell=new PdfPCell();
		
	
		}

	public void onTestSkipped(ITestResult result) {
		
		
		if (this.skipTable == null) {
			this.skipTable = new PdfPTable(new float[]{.3f, .3f, .1f});
			this.skipTable.setTotalWidth(20f);
			Paragraph p = new Paragraph("SKIPPED TESTS", new Font(Font.FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD));
			p.setAlignment(Element.ALIGN_CENTER);
			PdfPCell cell = new PdfPCell(p);
			cell.setColspan(4);
			cell.setBackgroundColor(BaseColor.YELLOW);
			this.skipTable.addCell(cell);
			
			cell = new PdfPCell(new Paragraph("TestCase"));
			cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			this.skipTable.addCell(cell);
			cell = new PdfPCell(new Paragraph("Method"));
			cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			this.skipTable.addCell(cell);
			cell = new PdfPCell(new Paragraph("Time (ms)"));
			cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			this.skipTable.addCell(cell);
			
		}
		
		String temp = result.getTestClass().toString().replaceAll("TestClass name=class", "").replace("[", "").replace("]", "");
	
		PdfPCell cell = new PdfPCell(new Paragraph(temp.replaceAll("automationFramework.", "").replaceAll("_TestCase", "")));
		this.skipTable.addCell(cell);
				cell = new PdfPCell(new Paragraph(result.getMethod().toString().replaceAll("\\[(.*?)\\]", "")));
		this.skipTable.addCell(cell);
		cell = new PdfPCell(new Paragraph("" + (result.getEndMillis()-result.getStartMillis())));
		this.skipTable.addCell(cell);
	
	}

	
	public void onStart(ITestContext context) {

		try {
			PdfWriter.getInstance(this.document, new FileOutputStream(context.getName()+".pdf"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.document.open();
		
		Paragraph p = new Paragraph(context.getName() ,
				FontFactory.getFont(FontFactory.HELVETICA, 20.0f, Font.BOLD, new BaseColor(0, 0, 255)));
				
		try {
			this.document.add(p);
			this.document.add(new Paragraph(new Date().toString()));
		} catch (DocumentException e1) {
			e1.printStackTrace();
		}
	}

	
	public void onFinish(ITestContext context) {
		
		
		try {
			
		
			if (this.failTable != null) {
			
				this.failTable.setSpacingBefore(15f);
				this.document.add(this.failTable);
				this.failTable.setSpacingAfter(15f);
			}
			
			if (this.successTable != null) {
			
				this.successTable.setSpacingBefore(15f);
				this.document.add(this.successTable);
				this.successTable.setSpacingBefore(15f);
			}
			
			if (this.skipTable != null) {
			
					this.skipTable.setSpacingBefore(15f);
					this.document.add(this.skipTable);
					this.skipTable.setSpacingBefore(15f);
				}
			
			if (this.reportTable != null) {
			
					this.reportTable.setSpacingBefore(15f);
					this.document.add(this.reportTable);
					this.reportTable.setSpacingBefore(15f);
					DataValues.testResult = "FALSE";
				}
		
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	
		
		this.document.close();
	}
	
	
	/*public static void log(Object o) {
		
	}*/
}

