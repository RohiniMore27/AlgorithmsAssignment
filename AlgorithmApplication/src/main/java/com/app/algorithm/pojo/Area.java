package com.app.algorithm.pojo;

import java.io.Serializable;

public class Area implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int length,breadth;

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getBreadth() {
		return breadth;
	}

	public void setBreadth(int breadth) {
		this.breadth = breadth;
	}

	public Area(int length, int breadth) {
		super();
		this.length = length;
		this.breadth = breadth;
	}

	public Area() {
		// TODO Auto-generated constructor stub
	}
	
}
