/**
 * 
 */
package fr.tbr.iamcore.exception;

/**
 * @author tbrou
 *
 */
public class DAOUpdateException extends Exception {
	
private final String updateFault;
	
	public DAOUpdateException(String message) {
		this.updateFault = message;
	}

	public String getSaveFault() {
		return updateFault;
	}

}
