package com.mrs.obj;

public enum TaskStatusEnum {
	NOTASSIGN(0), OPEN(1), INPROGRESS(2), RESOLVED(3), CANTFIX(4), REOPEN(5), CANCELED(6), CLOSE(7);

	private int value;

	private TaskStatusEnum(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

	public static TaskStatusEnum fromInt(int value) {
		switch (value) {
		case 0:
			return TaskStatusEnum.NOTASSIGN;
		case 1:
			return TaskStatusEnum.OPEN;
		case 2:
			return TaskStatusEnum.INPROGRESS;
		case 3:
			return TaskStatusEnum.RESOLVED;
		case 4:
			return TaskStatusEnum.CANTFIX;
		case 5:
			return TaskStatusEnum.REOPEN;
		case 6:
			return TaskStatusEnum.CANCELED;
		case 7:
			return TaskStatusEnum.CLOSE;
		default:
			break;
		}
		return null;
	}
}
