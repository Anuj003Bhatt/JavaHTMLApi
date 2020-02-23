package com.anuj.javahtmlapi.dom.dataelements;

import com.anuj.javahtmlapi.dom.DOMElement;

public class HTMLTableColumn extends DOMElement {

	private static final String TAG = "td";
	private static final String TAG_HEADER = "th";

	private Boolean isHeader = false;
	private DOMElement content = null;
	private String stringContent = null;

	public HTMLTableColumn() {
		super();
	}

	public HTMLTableColumn(String content) {
		super();
		this.stringContent = content;
	}

	public HTMLTableColumn(DOMElement element) {
		this.content = element;
	}

	public Boolean getIsHeader() {
		return isHeader;
	}

	public void setIsHeader(Boolean isHeader) {
		this.isHeader = isHeader;
	}

	public String getContent() {
		return content.toString();
	}

	public void setContent(DOMElement content) {
		this.content = content;
	}

	@Override
	public String getHTMLString() {
		// TODO Auto-generated method stub
		StringBuilder output = null;
		if (this.isHeader) {
			output = new StringBuilder("<" + TAG_HEADER);
		} else {
			output = new StringBuilder("<" + TAG);
		}
		output.append(getIdClassStyleString());
		output.append(">");
		
		if (this.content != null) {
			output.append(this.content);
		}
		if (this.stringContent != null) {
			output.append(this.stringContent);
		}

		if (this.isHeader) {
			output.append("</" + TAG_HEADER + ">");
		} else {
			output.append("</" + TAG + ">");
		}

		return output.toString();

	}

}
