package com.hynix.fdcTest.exception;

public class RecipeNotFoundException extends FdcBusinessException {
    public RecipeNotFoundException(String message) {
        super("RECIPE_NOT_FOUND", message);
    }
}