package com.mrs.obj;

public enum RoleEnum {
	CUSTOMER(0), STAFF(1), TECHMGR(2);
	
	private int value;
	
	private RoleEnum(int value) {
		this.value = value;
	}
	
	public int getRoleValue() {
		return this.value;
	}
}
