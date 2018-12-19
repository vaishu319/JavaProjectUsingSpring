package com.app.student.model;

public enum Programs {
	
	MIS("MIS"),
	CS("CS"),
	EM("EM"),
	SWEN("SWEN");
	
	private String name;
	
	private Programs(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
}
