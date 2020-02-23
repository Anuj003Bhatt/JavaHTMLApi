package com.anuj.javahtmlapi.dom.dataelements;

import com.anuj.javahtmlapi.dom.DOMElement;

/**
 * The class represents a basic HTML table row 
 * 
 * @author anujbhat
 *
 */
public class HTMLTableRow extends DOMElement {
	
	
	private static final String TAG = "tr";
	private Boolean isHeaderRow = false;
	private Integer numberOfColumns = 0;
	private HTMLTableColumn[] content = null;

	
	/**
	 * HTML table row constructor.
	 * Each row contains n number of columns and this constructor accepts the number of columns that will be in the row  
	 * @param n
	 */
	public HTMLTableRow(Integer n) {
		super();
		this.numberOfColumns = n;
		this.content = new HTMLTableColumn[this.numberOfColumns];
	}

	public Integer getNumberOfColumns() {
		return this.numberOfColumns;
	}
	
	/**
	 * 
	 * @param content
	 * @param index
	 */
	public void addColumnContentAtIndex(String content, Integer index) {
		if (index < 0 || index >= this.numberOfColumns) {
			return;
		}
		this.content[index] = new HTMLTableColumn(content);
		if (this.isHeaderRow) {
			this.content[index].setIsHeader(true);
		}

	}
	
	/**
	 * 
	 * @param content
	 * @param index
	 */
	public void addColumnContentAtIndex(DOMElement content, Integer index) {
		if (index < 0 || index >= this.numberOfColumns) {
			return;
		}
		this.content[index] = new HTMLTableColumn(content);
		if (this.isHeaderRow) {
			this.content[index].setIsHeader(true);
		}

	}
	/**
	 * 
	 * @param content
	 * @param index
	 */
	public void addColumnAtIndex(HTMLTableColumn content, Integer index) {
		if (index < 0 || index >= this.numberOfColumns) {
			return;
		}
		this.content[index] = content;
		if (this.isHeaderRow) {
			this.content[index].setIsHeader(true);
		}

	}

	
	
	/**
	 * 
	 * @param index
	 * @return
	 */
	public HTMLTableColumn getColumnAtIndex(Integer index) {
		return this.content[index];
	}
	

	@Override
	public String getHTMLString() {
		// TODO Auto-generated method stub
		StringBuilder output = new StringBuilder("<" + TAG);
		output.append(getIdClassStyleString());
		output.append(">");
		if (this.content != null) {
			for (int i = 0; i < this.numberOfColumns; i++) {
				if (this.content[i] != null) {
					output.append(this.content[i].toString());
				}
			}
		} else {

		}

		output.append("</" + TAG + ">");

		return output.toString();
	}

}
