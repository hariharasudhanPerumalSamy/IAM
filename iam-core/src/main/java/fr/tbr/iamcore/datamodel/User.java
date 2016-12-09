/**
 * 
 */
package fr.tbr.iamcore.datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author hariharasudhan
 *
 */

@Entity
@Table(name="USERS")
public class User {
	
	@Id
	@Column(name="INDEX")
	@GeneratedValue
	long id;
	
	private String login;
	private String password;
	
	public User()
	{
		super();
	}
	
	/**
	 * Constructor to initiate user object from username and password
	 * @param login - String
	 * @param password - String
	 */
	public User(final String login, final String password)
	{
		this.login = login;
		this.password = password;
	}
	
	/**
	 * @return the login
	 */
	public final String getLogin() {
		return login;
	}
	/**
	 * @param login the login to set
	 */
	public final void setLogin(String login) {
		this.login = login;
	}
	/**
	 * @return the password
	 */
	public String getPassWord() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassWord(String password) {
		this.password = password;
	}

}
