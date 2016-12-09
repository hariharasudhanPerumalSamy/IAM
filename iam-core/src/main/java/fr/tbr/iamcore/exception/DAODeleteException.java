package fr.tbr.iamcore.exception;

public class DAODeleteException extends Exception {
	
private final String deleteFault;
	
	public DAODeleteException(String message) {
		this.deleteFault = message;
	}

	public String getSaveFault() {
		return deleteFault;
	}
	

}
