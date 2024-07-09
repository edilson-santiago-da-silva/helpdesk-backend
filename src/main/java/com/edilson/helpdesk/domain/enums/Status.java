package com.edilson.helpdesk.domain.enums;

public enum Status {
	
	OPEN(0, "OPEN"), PROGRESS(1, "PROGRESS"), CLOSED(2,  "CLOSED");
	
	private Integer code;
	private String description;
	
	
	private Status(Integer code, String description) {
		this.code = code;
		this.description = description;
	}


	public Integer getCode() {
		return code;
	}


	public String getDescription() {
		return description;
	}

	public static Status toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(Status x : Status.values()) {
			if(cod.equals(x.getCode())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Invalid Status");
	}
	
}
