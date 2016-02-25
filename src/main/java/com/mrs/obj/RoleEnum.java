package com.mrs.obj;

public enum RoleEnum {
	TECHMGR(0), STAFF(1), CUSTOMER(2);
	
	private int value;
	
	private RoleEnum(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public static RoleEnum fromInt(int role) {
        switch(role) {
	        case 0:
	            return TECHMGR;
	        case 1:
	            return STAFF;
	        case 2:
	        	return CUSTOMER;
        }
        return null;
    }
}
