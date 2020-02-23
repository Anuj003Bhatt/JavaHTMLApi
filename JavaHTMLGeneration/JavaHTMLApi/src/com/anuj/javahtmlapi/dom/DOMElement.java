package com.anuj.javahtmlapi.dom;

/**
 * <b>DOMElement:</b> <br>
 * An abstract class that provides an implementation for a HTML element. This
 * includes the basic strings id, class and style attributes and an abstract
 * function getHTMLString() that return the string representation of the element
 * being implemented by then class
 * 
 * @author Anuj Narayan Bhatt
 *
 */
public abstract class DOMElement {

	protected StringBuilder id;
	protected StringBuilder className;
	protected StringBuilder style;

	/**
	 * DOM Contructor setting ID, style and class strings to null.
	 */
	public DOMElement() {
		this.id = null;
		this.className = null;
		this.style = null;
	}

	/**
	 * Get the ID of the tag
	 * 
	 * @return
	 */
	public StringBuilder getId() {
		return id;
	}

	/**
	 * Set a custom ID for element
	 * 
	 * @param id
	 */
	public void setId(String id) {
		this.id = new StringBuilder(id);
	}

	public void appendId(String id) {
		if (this.id == null) {
			this.id = new StringBuilder(id);
		} else {
			this.id.append(id);
		}
	}

	/**
	 * Get the class string.
	 * 
	 * @return
	 */
	public StringBuilder getClassName() {
		return className;
	}

	/**
	 * Set class to element
	 * 
	 * @param className
	 */
	public void setClassName(String className) {
		this.className = new StringBuilder(className);
	}

	/**
	 * Append a class name
	 * 
	 * @param className
	 */
	public void appendClassName(String className) {
		if (this.className == null) {
			this.className = new StringBuilder(className);
		} else {
			this.className.append(className);
		}
	}

	/**
	 * Get style string set to element
	 * 
	 * @return
	 */
	public StringBuilder getStyle() {
		return style;
	}

	/**
	 * Set the style on the element. Note set function replaces all the previous
	 * content. If you want to append use the appendStyle function
	 * 
	 * @param style
	 */
	public void setStyle(String style) {
		this.style = new StringBuilder(style);
	}

	/**
	 * Appends a string to the style element
	 * 
	 * @param style
	 */
	public void appendStyle(String style) {
		if (this.style == null) {
			this.style = new StringBuilder(style);
			return;
		}
		this.style.append(style);
	}

	/**
	 * An abstract function that implement the logic to return a string
	 * representation of the element being implemented in the inherited class
	 * 
	 * @return
	 */
	public abstract String getHTMLString();

	/**
	 * Returns an id + style + class string for the element. The getHTMLString needs
	 * to call this string in order to get the id style class string and append the
	 * same into the html being returned in the function.
	 * 
	 * @return
	 */
	public String getIdClassStyleString() {
		StringBuilder output = new StringBuilder("");
		if (this.id != null && !("".equals(this.id.toString()))) {
			output.append(" id=\"" + this.id.toString() + "\"");
		}

		if (this.className != null && !("".equals(this.className.toString()))) {
			output.append(" class=\"" + this.className.toString() + "\"");
		}

		if (this.style != null && !("".equals(this.style.toString()))) {
			output.append(" style=\"" + this.style.toString() + "\"");
		}

		return output.toString();

	}

	@Override
	public String toString() {
		return this.getHTMLString();
	}

}
