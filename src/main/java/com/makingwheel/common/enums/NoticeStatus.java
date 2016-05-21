package com.makingwheel.common.enums;

public enum NoticeStatus {

	NO_USED(0),
	USED(1);
	
	private int value;
	
	private NoticeStatus(int value){
		this.value = value;
	}
	
	public int getValue(){
		return value;
	}
}
