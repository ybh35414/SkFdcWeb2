package com.hynix.fdcTest.exception;

public class InvalidSvidFormatException extends FdcBusinessException {

	public InvalidSvidFormatException(String message) {
        super("SVID_FORMAT_ERROR", message);
    }
	
}