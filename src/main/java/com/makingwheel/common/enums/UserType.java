package com.makingwheel.common.enums;

public enum UserType {

	MANAGER(0),
	TEACHER(1),
	STUDENT(2);
	
	private int value;
	
	private UserType(int value){
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
