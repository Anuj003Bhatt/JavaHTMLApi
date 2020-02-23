package com.anuj.javahtmlapi.dom.elements;

import com.anuj.javahtmlapi.dom.DOMElement;

public class HTMLHead extends DOMElement {

	private StringBuilder title = null;
	private StringBuilder scripts = null;

	/**
	 * Get the title string. This string is eventually added to the title
	 * 
	 * @return
	 */
	public StringBuilder getTitle() {
		return title;
	}

	/**
	 * 
	 * Encapsulates the string provided in script tags and returns the string
	 * 
	 * @param script
	 * 
	 */
	public void addScript(String script) {
		if (this.scripts == null) {
			this.scripts = new StringBuilder();
		}
		this.scripts.append(script);

	}

	/**
	 * Function to set the title of this HTML document
	 * 
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = new StringBuilder(title);
	}

	/**
	 * Forms the head tag from the contents set in the object and return a string
	 * representation of the HTML head
	 * 
	 * @return
	 */
	@Override
	public String getHTMLString() {

		// Start head tag
		StringBuffer head = new StringBuffer("<head>");

		// Append title tag to the header
		if (null == this.title || "".equals(this.title.toString())) {
			head.append("<title>No Title</title>");
		} else {
			head.append("<title>" + this.title + "</title>");
		}

		// Append style tag if any
		if (null != this.style && !("".equals(this.style.toString()))) {
			head.append("<style>" + this.style.toString() + "</style>");
		}

		if (this.scripts != null) {
			head.append("<script>" + this.scripts.toString() + "</script>");
		}

		// Close head tag
		head.append("</head>");

		return head.toString();
	}

}
