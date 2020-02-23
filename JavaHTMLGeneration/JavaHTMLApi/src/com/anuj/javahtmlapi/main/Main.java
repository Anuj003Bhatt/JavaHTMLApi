package com.anuj.javahtmlapi.main;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.anuj.javahtmlapi.dom.dataelements.HTMLTable;
import com.anuj.javahtmlapi.dom.elements.HTMLTag;
import com.anuj.javahtmlapi.exceptions.InvalidTextTypeException;
import com.anuj.javahtmlapi.reporttemplate.HTMLReport;
import com.anuj.javahtmlapi.reporttemplate.ReportSection;

public class Main {

	public static void showHTML(String html) throws IOException {
		File htmlFile = null;
		FileWriter writer = null;
		try {
			htmlFile = new File("C:\\Users\\Anuj Narayan Bhatt\\Desktop\\Sample.html");
			writer = new FileWriter(htmlFile, false);
			writer.flush();

			writer.append(html.toString());
			writer.close();
			writer = null;
			Desktop.getDesktop().browse(htmlFile.toURI());
		} finally {
			if (writer != null) {
				writer.close();
			}

		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		HTMLReport sampleReport = new HTMLReport();
		ReportSection section = new ReportSection();
		section.setHeaderText("Header Text");
		
		HTMLTag text = new HTMLTag();
		try {
			text.setType(HTMLTag.TEXT_PARAGRAPH);
		} catch (InvalidTextTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		text.setText("Hello World !!");
		
		section.setinnerDivDetails(text);
		sampleReport.addSection(section);
		
		
		String[][] dataTable = new String[57][6];
		
		BufferedReader csvReader = new BufferedReader(new FileReader("C:\\Users\\Anuj Narayan Bhatt\\Desktop\\DataTables.csv"));
		String row = null;
		row = csvReader.readLine();
		String[] headers = row.split(",");
		int i=0;
		while ((row = csvReader.readLine()) != null) {
		    dataTable[i++] = row.split(",");
		    // do something with the data
		}
		csvReader.close();
		
		HTMLTable table = new HTMLTable(headers, dataTable);
		
		ReportSection section1 = new ReportSection();
		section1.setHeaderText("Data Table");
		section1.setinnerDivDetails(table);
		
		sampleReport.addSection(section1);
		
		Main.showHTML(sampleReport.toString());

		
	}

}
