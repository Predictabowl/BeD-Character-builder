package org.predictabowl.bed.commons.exceptions;

public class BeDIllegalValueException extends IllegalArgumentException{

	private static final long serialVersionUID = 1L;

	public BeDIllegalValueException() {
		super();
	}
	
	public BeDIllegalValueException(String msg) {
		super(msg);
	}
}
