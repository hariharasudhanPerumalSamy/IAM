/**
 * 
 */
package fr.tbr.iamcore.datamodel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author tbrou
 *
 */

@Entity
@Table(name="IDENTITIES")
public class Identity {
	
	@Id
	@Column(name="INDEX")
	@GeneratedValue
	long id;
	
	private String displayName;
	private String email;
	private String uid;
	private Date birthDate;
	
	
	/**
	 * 
	 */
	public Identity() {
		super();
	}
	
	/**
	 * @param displayName
	 * @param email
	 * @param uid
	 */
	public Identity(String displayName, String email, String uid, Date birthDate) {
		this.displayName = displayName;
		this.email = email;
		this.uid = uid;
		this.birthDate = birthDate;
	}
	
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the displayName
	 */
	public String getDisplayName() {
		return displayName;
	}
	/**
	 * @param displayName the displayName to set
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the uid
	 */
	public String getUid() {
		return uid;
	}
	/**
	 * @param uid the uid to set
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Identity [displayName=" + displayName + ", email=" + email
				+ ", uid=" + uid + "]";
	}

	/**
	 * @param birthDate
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
		
	}

	/**
	 * @return the birthDate
	 */
	public final Date getBirthDate() {
		return birthDate;
	}
	
	
	

}
