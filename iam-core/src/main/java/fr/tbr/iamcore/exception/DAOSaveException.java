package fr.tbr.iamcore.exception;

public class DAOSaveException extends Exception {

	private final String saveFault;
	
	public DAOSaveException(String message) {
		this.saveFault = message;
	}

	public String getSaveFault() {
		return saveFault;
	}


}
