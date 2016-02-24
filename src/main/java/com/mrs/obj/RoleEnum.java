package com.mrs.obj;

public enum RoleEnum {
	TECHMGR, STAFF, CUSTOMER;
	
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
