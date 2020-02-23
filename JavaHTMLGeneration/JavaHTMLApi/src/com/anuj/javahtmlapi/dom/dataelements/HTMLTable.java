package com.anuj.javahtmlapi.dom.dataelements;

import com.anuj.javahtmlapi.dom.DOMElement;

public class HTMLTable extends DOMElement {
	private Integer autoIncrementId = 1;
	private static final String TAG = "table";

	private HTMLTableRow[] rows = null;
	private HTMLTableRow headerRow = null;

	public HTMLTable(String[] headers, String[][] values) {

		this.rows = new HTMLTableRow[values.length];
		if (headers != null) {
			this.headerRow = new HTMLTableRow(headers.length);
		}

		if (headers != null) {
			for (int i = 0; i < headers.length; i++) {
				this.headerRow.addColumnContentAtIndex(headers[i], i);
				this.headerRow.getColumnAtIndex(i).setIsHeader(true);
			}
		}

		for (int i = 0; i < values.length; i++) {
			this.rows[i] = new HTMLTableRow(values[i].length);
			this.rows[i].setId((this.autoIncrementId).toString());
			this.rows[i].setClassName("A" + (this.autoIncrementId++).toString());
			for (int j = 0; j < values[i].length; j++) {

				this.rows[i].addColumnContentAtIndex(values[i][j], j);
				this.rows[i].getColumnAtIndex(j).setId((this.autoIncrementId).toString());
				this.rows[i].getColumnAtIndex(j).setClassName("B" + (this.autoIncrementId++).toString());
			}
		}

	}

	public HTMLTable(DOMElement[] headers, DOMElement[][] values) {
		this.rows = new HTMLTableRow[values.length];
		if (headers != null) {
			this.headerRow = new HTMLTableRow(headers.length);
		}

		if (headers != null) {
			for (int i = 0; i < headers.length; i++) {
				this.headerRow.addColumnContentAtIndex(headers[i], i);
				this.headerRow.getColumnAtIndex(i).setIsHeader(true);
			}
		}

		for (int i = 0; i < values.length; i++) {
			this.rows[i] = new HTMLTableRow(values[i].length);
			this.rows[i].setId((this.autoIncrementId).toString());
			this.rows[i].setClassName("A" + (this.autoIncrementId++).toString());
			for (int j = 0; j < values[i].length; j++) {

				this.rows[i].addColumnContentAtIndex(values[i][j], j);
				this.rows[i].getColumnAtIndex(j).setId((this.autoIncrementId).toString());
				this.rows[i].getColumnAtIndex(j).setClassName("B" + (this.autoIncrementId++).toString());
			}
		}

	}

	public HTMLTableRow getHTMLRowAtIndex(Integer index) {
		return this.rows[index];
	}

	public HTMLTableColumn getColumnAtIndex(Integer row, Integer column) {
		return this.rows[row].getColumnAtIndex(column);
	}

	@Override
	public String getHTMLString() {
		// TODO Auto-generated method stub
		StringBuilder output = new StringBuilder("<" + TAG);
		output.append(getIdClassStyleString());
		output.append(">");

		output.append(this.headerRow);
		for (int i = 0; i < this.rows.length; i++) {
			output.append(this.rows[i].toString());
		}

		output.append("</" + TAG + ">");

		return output.toString();
	}

}
