 package com.anuj.javahtmlapi.dom.elements;

import java.util.HashMap; 
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.anuj.javahtmlapi.dom.DOMElement;



/**
 * 
 * @author anujbhat
 *
 */
public class HTMLFormattedText extends DOMElement {

	private Map<Integer, String> tags;
	public static final int BOLD = 1;
	public static final int STRONG = 2;
	public static final int ITALICS = 3;
	public static final int EMPHASIZED = 4;
	public static final int MARKED = 5;
	public static final int SMALL = 6;
	public static final int DELETED = 7;
	public static final int INSERTED = 8;
	public static final int SUBSCRIPT = 9;
	public static final int SUPERSCRIPT = 10;

	private Set<Integer> order;

	private StringBuilder text = null;

	public void initializeTags() {
		this.order = new HashSet<Integer>();
		this.tags = new HashMap<Integer, String>();

		this.tags.put(HTMLFormattedText.BOLD, "b");
		this.tags.put(HTMLFormattedText.STRONG, "strong");
		this.tags.put(HTMLFormattedText.ITALICS, "i");
		this.tags.put(HTMLFormattedText.EMPHASIZED, "em");
		this.tags.put(HTMLFormattedText.MARKED, "mark");
		this.tags.put(HTMLFormattedText.SMALL, "small");
		this.tags.put(HTMLFormattedText.DELETED, "del");
		this.tags.put(HTMLFormattedText.INSERTED, "ins");
		this.tags.put(HTMLFormattedText.SUBSCRIPT, "sub");
		this.tags.put(HTMLFormattedText.SUPERSCRIPT, "sup");
	}

	public HTMLFormattedText() {
		initializeTags();
	}

	public HTMLFormattedText(String text) {
		initializeTags();
		this.text = new StringBuilder(text);
	}

	/**
	 * 
	 * @param content
	 */
	public void setContent(String content) {
		this.text = new StringBuilder(content);
	}

	/**
	 * 
	 * @param content
	 */
	public void appendContent(StringBuilder content) {
		if (this.text == null) {
			this.text = content;
		} else {
			this.text.append(content);
		}
	}

	/**
	 * 
	 * @param value
	 */
	public HTMLFormattedText setTextFormattingBold() {
		this.order.add(HTMLFormattedText.BOLD);
		return this;
	}

	/**
	 * 
	 */
	public HTMLFormattedText removeTextFormattingBold() {
		if (!this.order.contains(HTMLFormattedText.BOLD)) {
			return this;
		}
		this.order.remove(HTMLFormattedText.BOLD);
		return this;
	}

	/**
	 * 
	 * @param value
	 */
	public HTMLFormattedText setTextFormattingStrong() {
		this.order.add(HTMLFormattedText.STRONG);
		return this;
	}

	/**
	 * 
	 */
	public HTMLFormattedText removeTextFormattingStrong() {
		if (!this.order.contains(HTMLFormattedText.STRONG)) {
			return this;
		}
		this.order.remove(HTMLFormattedText.STRONG);
		return this;
	}

	/**
	 * 
	 * @param value
	 */
	public HTMLFormattedText setTextFormattingItalics() {
		this.order.add(HTMLFormattedText.ITALICS);
		return this;
	}

	/**
	 * 
	 */
	public HTMLFormattedText removeTextFormattingItalics() {
		if (!this.order.contains(HTMLFormattedText.ITALICS)) {
			return this;
		}
		this.order.remove(HTMLFormattedText.ITALICS);
		return this;
	}

	/**
	 * 
	 * @param value
	 */
	public HTMLFormattedText setTextFormattingEmphasized() {
		this.order.add(HTMLFormattedText.EMPHASIZED);
		return this;
	}

	/**
	 * 
	 */
	public HTMLFormattedText removeTextFormattingEmphasized() {
		if (!this.order.contains(HTMLFormattedText.EMPHASIZED)) {
			return this;
		}
		this.order.remove(HTMLFormattedText.EMPHASIZED);
		return this;
	}

	/**
	 * 
	 * @param value
	 */
	public HTMLFormattedText setTextFormattingMarked() {
		this.order.add(HTMLFormattedText.MARKED);
		return this;
	}

	/**
	 * 
	 */
	public HTMLFormattedText removeTextFormattingMarked() {
		if (!this.order.contains(HTMLFormattedText.MARKED)) {
			return this;
		}
		this.order.remove(HTMLFormattedText.MARKED);
		return this;
	}

	/**
	 * 
	 * @param value
	 */
	public HTMLFormattedText setTextFormattingSmall() {
		this.order.add(HTMLFormattedText.SMALL);
		return this;
	}

	/**
	 * 
	 */
	public HTMLFormattedText removeTextFormattingSmall() {
		if (!this.order.contains(HTMLFormattedText.SMALL)) {
			return this;
		}
		this.order.remove(HTMLFormattedText.SMALL);
		return this;
	}

	/**
	 * 
	 * @param value
	 */
	public HTMLFormattedText setTextFormattingDeleted() {
		this.order.add(HTMLFormattedText.DELETED);
		return this;
	}

	/**
	 * 
	 */
	public HTMLFormattedText removeTextFormattingDeleted() {
		if (!this.order.contains(HTMLFormattedText.DELETED)) {
			return this;
		}
		this.order.remove(HTMLFormattedText.DELETED);
		return this;
	}

	/**
	 * 
	 * @param value
	 */
	public HTMLFormattedText setTextFormattingInserted() {
		this.order.add(HTMLFormattedText.INSERTED);
		return this;
	}

	/**
	 * 
	 */
	public HTMLFormattedText removeTextFormattingInserted() {
		if (!this.order.contains(HTMLFormattedText.INSERTED)) {
			return this;
		}
		this.order.remove(HTMLFormattedText.INSERTED);
		return this;
	}

	/**
	 * 
	 * @param value
	 */
	public HTMLFormattedText setTextFormattingSubscript() {
		this.order.add(HTMLFormattedText.SUBSCRIPT);
		return this;
	}

	/**
	 * 
	 */
	public HTMLFormattedText removeTextFormattingsubscript() {
		if (!this.order.contains(HTMLFormattedText.SUBSCRIPT)) {
			return this;
		}
		this.order.remove(HTMLFormattedText.SUBSCRIPT);
		return this;
	}

	/**
	 * 
	 * @param value
	 */
	public HTMLFormattedText setTextFormattingSuperscript() {
		this.order.add(HTMLFormattedText.SUPERSCRIPT);
		return this;
	}

	/**
	 * 
	 */
	public HTMLFormattedText removeTextFormattingSuperscript() {
		if (!this.order.contains(HTMLFormattedText.SUPERSCRIPT)) {
			return this;
		}
		this.order.remove(HTMLFormattedText.SUPERSCRIPT);
		return this;
	}

	@Override
	public String getHTMLString() {
		// TODO Auto-generated method stub
		StringBuilder output = new StringBuilder("");
		StringBuilder tail = new StringBuilder("");

		for (Integer order : this.order) {
			output.append("<");
			output.append(this.tags.get(order));
			output.append(">");

			tail.insert(0, "</" + this.tags.get(order) + ">");
		}

		output.append(this.text);

		output.append(tail);

		return output.toString();
	}

}
