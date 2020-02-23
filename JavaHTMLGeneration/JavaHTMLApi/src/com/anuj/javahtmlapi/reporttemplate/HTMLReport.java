package com.anuj.javahtmlapi.reporttemplate;

import java.util.LinkedList;

import com.anuj.javahtmlapi.dom.DOMElement;
import com.anuj.javahtmlapi.dom.elements.HTMLHead;
import com.anuj.javahtmlapi.dom.elements.HTMLTag;
import com.anuj.javahtmlapi.exceptions.InvalidHTMLException;
import com.anuj.javahtmlapi.exceptions.InvalidTextTypeException;
import com.anuj.javahtmlapi.htmlapi.HTML;

public class HTMLReport extends DOMElement {
	private LinkedList<ReportSection> sections;

	public HTMLReport() {
		this.sections = new LinkedList<ReportSection>();
		this.setStyle(null);
	}

	public void addSection(ReportSection section) {
		if (this.sections == null) {
			this.sections = new LinkedList<ReportSection>();
		}
		this.sections.add(section);
	}

	@Override
	public String getHTMLString() {
		// TODO Auto-generated method stub

		HTML html = new HTML();

		HTMLHead head = new HTMLHead();
		head.setTitle("SampleTitle");
		head.appendStyle(this.style.toString());
		html.setHead(head);

		HTMLTag body = new HTMLTag();
		try {
			body.setType(HTMLTag.BODY);
			for (ReportSection section : this.sections) {
				body.addElement(section);
			}
			html.setBody(body);
		} catch (InvalidTextTypeException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvalidHTMLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return html.toString();
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setClassName(String className) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setStyle(String style) {
		// TODO Auto-generated method stub
		
		this.appendStyle("table {\n" + 
				"  font-family: arial, sans-serif;\n" + 
				"  border-collapse: collapse;\n" + 
				"  width: 100%;\n" + 
				"}\n" + 
				"\n" + 
				"td, th {\n" + 
				"  border: 1px solid #dddddd;\n" + 
				"  text-align: left;\n" + 
				"  padding: 8px;\n" + 
				"}\n" + 
				"\n" + 
				"tr:nth-child(even) {\n" + 
				"  background-color: #dddddd;\n" + 
				"}");
	}

}
