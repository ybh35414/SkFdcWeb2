package com.hynix.fdcTest.exception;

public class FdcBusinessException extends RuntimeException {
	
    private final String errorType;

    public FdcBusinessException(String errorType, String message) {
        super(message);
        this.errorType = errorType;
    }
    
    public String getErrorType() { return errorType; }
}