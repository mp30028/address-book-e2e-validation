package com.zonesoft.addressbook.e2e_validation.exceptions;

public class AddressBookE2eException extends RuntimeException {
	private static final long serialVersionUID = 3365111151656618159L;
	
	public AddressBookE2eException() {
		    super();
	}

	public AddressBookE2eException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		    super(message, cause, enableSuppression, writableStackTrace);
	}

	public AddressBookE2eException(String message, Throwable cause) {
		    super(message, cause);
	}

	public AddressBookE2eException(String message) {
		    super(message);
	}

	public AddressBookE2eException(Throwable cause) {
		    super(cause);
	}

}
