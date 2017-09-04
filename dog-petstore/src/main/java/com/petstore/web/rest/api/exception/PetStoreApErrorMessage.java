package com.petstore.web.rest.api.exception;

public class PetStoreApErrorMessage {
	private String statusCode;
	private String message;
	private String exception;
	private String url;

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "PetStoreApErrorMessage [statusCode=" + statusCode + ", message=" + message + ", exception="
				+ exception + ", url=" + url + "]";
	}

}
