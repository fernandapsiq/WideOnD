package com.fernanda.wideond.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	// error searching by id
	public ResourceNotFoundException(Long id) {
		super("Resource with " + id + " has not been founded.");
	}
	
	// error searching by resorce name
	public ResourceNotFoundException(String resourceName) {
		super("Resource \"" + resourceName + "\" has not been founded.");
	}
	
}
