package com.anuj.javahtmlapi.reporttemplate;

import com.anuj.javahtmlapi.dom.DOMElement;
import com.anuj.javahtmlapi.exceptions.InvalidTextTypeException;
import com.anuj.javahtmlapi.dom.elements.HTMLTag;

public class ReportSection extends DOMElement {
	private HTMLTag outerDiv = null;
	private HTMLTag innerDivHeader = null;
	private HTMLTag innerDivDetails = null;
	private HTMLTag headerText = null;

	public ReportSection() {
		this.outerDiv = new HTMLTag();
		this.innerDivHeader = new HTMLTag();
		this.innerDivDetails = new HTMLTag();

		try {
			this.outerDiv.setType(HTMLTag.DIV);
			this.innerDivHeader.setType(HTMLTag.DIV);
			this.innerDivDetails.setType(HTMLTag.DIV);
		} catch (InvalidTextTypeException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		this.outerDiv.addElement(this.innerDivHeader);
		this.outerDiv.addElement(this.innerDivDetails);

		this.headerText = new HTMLTag();

		try {
			this.headerText.setType(HTMLTag.TEXT_HEADER);

		} catch (InvalidTextTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.innerDivHeader.addElement(this.headerText);

		this.outerDiv.setStyle("margin:2%;");
		this.outerDiv.appendStyle("border:groove;");
		this.outerDiv.appendStyle("border-radius:10px;");
		this.outerDiv.appendStyle("box-shadow: 5px 10px #888888;");
		this.outerDiv.appendStyle("position: relative;");

		this.innerDivHeader.addLineSeparator();
		this.innerDivHeader.appendStyle("margin: 2%; height: 30%;");

		this.innerDivDetails.appendStyle("margin: 2%;height: 70%;");

	}

	public ReportSection setHeaderText(String text) {
		if (this.headerText != null) {
			this.headerText.setText(text);
		}
		return this;
	}

	public ReportSection setinnerDivDetails(DOMElement element) {
		if (this.innerDivDetails != null) {
			this.innerDivDetails.removeAllElements();
			this.innerDivDetails.addElement(element);
		}
		return this;
	}

	public ReportSection addinnerDivDetails(DOMElement element) {

		if (this.innerDivDetails != null) {
			this.innerDivDetails.addElement(element);
		}

		return this;
	}

	@Override
	public String getHTMLString() {
		// TODO Auto-generated method stub
		if (this.outerDiv != null) {
			return this.outerDiv.toString();
		}
		return null;

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

	}

}
