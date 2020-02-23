package com.anuj.javahtmlapi.dom.elements;

import java.util.LinkedList;

import com.anuj.javahtmlapi.dom.DOMElement;
import com.anuj.javahtmlapi.exceptions.InvalidPropertyValue;
import com.anuj.javahtmlapi.exceptions.InvalidTextTypeException;
import com.anuj.javahtmlapi.exceptions.PropertyNotDefinedException;

/**
 * <b>HTMLTag: <b><br>
 * This class represents a basic tag that can contain any elements. For example:
 * p, h, a, body and div elements. <br>
 * <br>
 * The class maintains the order in which the elements are being added and are
 * eventually being rendered in the same way.
 * 
 * @author Anuj Narayan Bhatt
 *
 */
public class HTMLTag extends DOMElement {

	private String TAG = null;
	public static final String TEXT_SIMPLE = null;
	public static final String TEXT_PARAGRAPH = "p";
	public static final String TEXT_HEADER = "h";
	public static final String TEXT_LINK = "a";
	public static final String BODY = "body";
	public static final String DIV = "div";

	private LinkedList<DOMElement> elements = null;

	private String link = "#";
	private Integer level = 1;

	/**
	 * Adds an element inside the tag.
	 * 
	 * @param element
	 * @return
	 */
	public HTMLTag addElement(DOMElement element) {
		if (this.elements == null) {
			this.elements = new LinkedList<DOMElement>();
		}

		this.elements.add(element);

		return this;
	}

	/**
	 * Removes all element and clears the current tag.
	 */
	public void removeAllElements() {
		if (this.elements != null) {
			this.elements.clear();
		}
	}

	/**
	 * Adds an HR tag to add a line separator.
	 * 
	 * @return
	 */
	public HTMLTag addLineSeparator() {
		HTMLTag text = new HTMLTag();
		text.setText("<hr>");
		this.elements.add(text);
		return this;
	}

	public HTMLTag() {
		super();
	}

	/**
	 * 
	 * Sets the text as a Formatted HTML Text. By default no formatting is done.
	 * 
	 * 
	 * @param text
	 * @return
	 */
	public HTMLTag setText(String text) {
		if (this.elements == null) {
			this.elements = new LinkedList<DOMElement>();
			this.elements.add(new HTMLFormattedText(text));
			return this;
		}
		this.elements.clear();
		this.elements.add(new HTMLFormattedText(text));

		return this;
	}

	/**
	 * 
	 * Appends string content as a separate HTML Formatted text.
	 * 
	 * @param content
	 * @return
	 */
	public HTMLTag addStringContent(String content) {

		if (this.elements == null) {
			this.elements = new LinkedList<DOMElement>();
			this.elements.add(new HTMLFormattedText(content));
		} else {
			this.elements.add(new HTMLFormattedText(content));
		}

		return this;
	}

	/**
	 * 
	 * Appends the Formatted text in the list of elements.
	 * 
	 * @param content
	 * @return
	 */
	public HTMLTag addFormattedHTMLContent(HTMLFormattedText content) {

		if (this.elements == null) {
			this.elements = new LinkedList<DOMElement>();
			this.elements.add(content);
		} else {
			this.elements.add(content);
		}

		return this;
	}

	/**
	 * 
	 * Sets the type of Tag being created. <br>
	 * <br>
	 * Default value is simple text in which no tag will be implemented and the
	 * string is added as a simple text. <br>
	 * <br>
	 * 
	 * <b>Type values supported: Simple text(default), para (p tag), header (h tag),
	 * a (a tag, link), body, div </b><br>
	 * <br>
	 * 
	 * If a value other than above is passed it will throw an exception.<br>
	 * 
	 * @param type
	 * @return
	 * @throws InvalidTextTypeException
	 */
	public HTMLTag setType(String type) throws InvalidTextTypeException {

		if (HTMLTag.TEXT_SIMPLE == type) {
			return this;
		}

		switch (type) {
		case HTMLTag.TEXT_PARAGRAPH:
			this.TAG = HTMLTag.TEXT_PARAGRAPH;
			return this;
		case HTMLTag.TEXT_HEADER:
			this.TAG = HTMLTag.TEXT_HEADER;
			return this;
		case HTMLTag.TEXT_LINK:
			this.TAG = HTMLTag.TEXT_LINK;
			return this;
		case HTMLTag.BODY:
			this.TAG = HTMLTag.BODY;
			return this;
		case HTMLTag.DIV:
			this.TAG = HTMLTag.DIV;
			return this;
		default:
			throw new InvalidTextTypeException();
		}
	}

	/**
	 * 
	 * In case of an header text set the level as h1,h2,h3 tag. <br/>
	 * <br/>
	 * <b>Number of levels supported: 6</b> <br>
	 * <br>
	 * If this function is called for another type of tag or a level beyond [1,6]
	 * inclusive the function will throw an exception
	 * 
	 * 
	 * @param level
	 * @return
	 * @throws PropertyNotDefinedException
	 * @throws InvalidPropertyValue
	 */
	public HTMLTag setLevel(Integer level) throws PropertyNotDefinedException, InvalidPropertyValue {
		if (this.TAG != HTMLTag.TEXT_LINK) {
			throw new PropertyNotDefinedException("Level cannot be set for an HTML element of type: " + this.TAG);
		}

		if (level > 6 || level < 1) {
			throw new InvalidPropertyValue("Input level out of range: Please input a level between 1 to 6 [inclusive]");
		}

		this.level = level;

		return this;

	}

	/**
	 * 
	 * Sets the link for a tag. If the tag is not a link tag then the function
	 * throws an exception.
	 * 
	 * @param link
	 * @return
	 * @throws PropertyNotDefinedException
	 */
	public HTMLTag setLink(String link) throws PropertyNotDefinedException {
		if (this.TAG != HTMLTag.TEXT_LINK) {
			throw new PropertyNotDefinedException(
					"Link (href ) cannot be set for an HTML element of type: " + this.TAG);
		}

		this.link = link;
		return this;

	}

	/**
	 * 
	 * Get the tags that is set for the object.
	 * 
	 * @return
	 */
	public String getType() {
		return this.TAG;
	}

	@Override
	public String getHTMLString() {
		// TODO Auto-generated method stub
		StringBuilder output = new StringBuilder("");
		if (this.TAG != HTMLTag.TEXT_SIMPLE) {
			output = new StringBuilder("<" + TAG);
			output.append(getIdClassStyleString());

			if (this.TAG == HTMLTag.TEXT_HEADER) {
				output.append(this.level);
			}

			if (this.TAG == HTMLTag.TEXT_LINK) {
				output.append(" href=\"" + this.link + "\"");
			}

			output.append(">");
		}

		if (this.elements != null && this.elements.size() > 0) {
			for (DOMElement text : this.elements) {
				output.append(text);
			}
		}
		if (this.TAG != HTMLTag.TEXT_SIMPLE) {

			output.append("</" + TAG);
			if (this.TAG == HTMLTag.TEXT_HEADER) {
				output.append(this.level);
			}
			output.append(">");
		}
		return output.toString();
	}

}
