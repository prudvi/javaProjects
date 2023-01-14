package com.example.demo.pdfreader;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class ReadFromPDF {

	public static void main(String[] args) throws IOException {
		PDDocument document = PDDocument.load(
				//new File("C:\\Users\\prudv\\Downloads\\Q2FY23_Shareholder_Report.pdf")
				new File("C:\\Users\\prudv\\Downloads\\HCLTechTranscript.pdf")
				
				//new File("https://www.bseindia.com/xml-data/corpfiling/AttachHis/0a406998-cb81-4b05-bb1e-b3ac647af4ee.pdf")
				);
		if (!document.isEncrypted()) {
		    PDFTextStripper stripper = new PDFTextStripper();
		    String text = stripper.getText(document);
		    if (text.indexOf("we will now begin the question and answer") >= 0) {
		    	String[] splitT = text.split("we will now begin the question and answer");
		    	System.out.println("Text:" + splitT[1]);
		    }
		    
		}
		document.close();
	}
}
