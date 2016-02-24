package com.mrs.obj;

public enum OrderStatusEnum {
	PENDING(0), WAITING(1), REPAIRING(2), CANCELED(3), FINISH(4);

	private int value;
	
	private OrderStatusEnum(int value) {
		this.value = value;
	}
	
	public static OrderStatusEnum fromInt(int role) {
		switch (role) {
		case 0:
			return PENDING;
		case 1:
			return WAITING;
		case 2:
			return REPAIRING;
		case 3:
			return CANCELED;
		case 4:
			return FINISH;
		}
		return null;
	}

	public int getValue() {
		return value;
	}
}
