/**
 * 
 */
package fr.tbr.iamcore.exception;

/**
 * @author tbrou
 *
 */
public class DAOResourceException extends Exception {
	
private final String resourceFault;
	
	public DAOResourceException(String message) {
		this.resourceFault = message;
	}

	public String getSaveFault() {
		return resourceFault;
	}

}
