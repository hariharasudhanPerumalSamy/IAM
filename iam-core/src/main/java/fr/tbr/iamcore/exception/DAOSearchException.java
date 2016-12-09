/**
 * 
 */
package fr.tbr.iamcore.exception;

/**
 * @author tbrou
 *
 */
public class DAOSearchException extends Exception {
	
private final String searchFault;
	
	public DAOSearchException(String message) {
		this.searchFault = message;
	}

	public String getSaveFault() {
		return searchFault;
	}

}
