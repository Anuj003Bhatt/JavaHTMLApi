package com.anuj.javahtmlapi.dom.dataelements;

import java.util.LinkedList;

import com.anuj.javahtmlapi.dom.DOMElement;
import com.anuj.javahtmlapi.dom.elements.HTMLTag;
import com.anuj.javahtmlapi.exceptions.InvalidTextTypeException;


class HTMLListItem extends DOMElement {
	private String tag = "li"; 
	private DOMElement element;
	
	
	public DOMElement getElement() {
		return element;
	}


	public void setElement(DOMElement element) {
		this.element = element;
	}


	@Override
	public String getHTMLString() {
		// TODO Auto-generated method stub
		StringBuilder output = new StringBuilder("<" + this.tag);
		output.append(getIdClassStyleString());
		output.append(">");
		output.append(element);
		output.append("</ "+ tag + ">");
		return null;
	}
	
}


public class HTMLList extends DOMElement {
	
	LinkedList<HTMLListItem> list;
	private String CONTAINER_TAG = "ol";

	public HTMLList() {
		this.list = new LinkedList<HTMLListItem>();
	}

	public HTMLList createOrderedList() {
		this.CONTAINER_TAG = "ol";
		return this;
	}
	
	public HTMLList createUnOrderedList() {
		this.CONTAINER_TAG = "ul";
		return this;
	}
	
	public HTMLList addElement(DOMElement element) {
		HTMLListItem item = new HTMLListItem();
		item.setElement(element);
		
		
		if (this.list == null) {
			list = new LinkedList<HTMLListItem>();
		}
		
		list.add(item);
		return this;
	}
	
	public HTMLList addElement(String element) {
		HTMLTag para = new HTMLTag();
		try {
			para.setType(HTMLTag.TEXT_PARAGRAPH);
		} catch (InvalidTextTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HTMLListItem item = new HTMLListItem();
		item.setElement(para);
		if (this.list == null) {
			list = new LinkedList<HTMLListItem>();
		}
		
		list.add(item);
		return this;
	}
	
	public HTMLList clear() {
		if (this.list != null) {
			list.clear();
		}
		return this;
	}

	@Override
	public String getHTMLString() {
		// TODO Auto-generated method stub
		StringBuilder output = new StringBuilder("<" + this.CONTAINER_TAG );
		output.append(getIdClassStyleString());
		output.append(">");
		
		for(DOMElement element : this.list) {
			output.append(element);
			
		}
		
		output.append("</" + this.CONTAINER_TAG + ">");
		return output.toString();
	}
	
	

}
