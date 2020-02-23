package com.anuj.javahtmlapi.htmlapi;

import com.anuj.javahtmlapi.dom.elements.HTMLTag;
import com.anuj.javahtmlapi.dom.elements.HTMLHead;
import com.anuj.javahtmlapi.exceptions.InvalidHTMLException;


public class HTML {
	// Every instance of the HTML being generated is kept in below variable
	private static final String DOCTYPE = "<!DOCTYPE html>";
	private HTMLHead head = null;
	private HTMLTag body = null;

	public HTML() {
		super();

	}

	public HTMLHead getHead() {
		return this.head;
	}

	public HTML setHead(HTMLHead head) {
		this.head = head;
		return this;
	}
	
	public void setBody(HTMLTag body) throws InvalidHTMLException {
		if(body.getType() != HTMLTag.BODY) {
			throw new InvalidHTMLException();
		}
		this.body = body;
	}


	/**
	 * This function erases the entire current body content.
	 * 
	 * @param bodyContent
	 */
	public void eraseContent(String bodyContent) {
		this.body = null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub

		StringBuffer html = new StringBuffer(HTML.DOCTYPE);
		html.append("<html>");
		if (head != null) {
			html.append(head);
		}
		if (body != null) {
			html.append(body);
		}

		html.append("</html>");

		return html.toString();
	}

}
